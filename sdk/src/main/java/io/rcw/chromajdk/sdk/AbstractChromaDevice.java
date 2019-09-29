package io.rcw.chromajdk.sdk;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class AbstractChromaDevice implements ChromaDevice {

    protected ChromaEffect currentEffect;

    private ScheduledFuture<?> scheduledTask;
    private long currentEffectStartTime = -1;

    private final ChromaConfiguration configuration;

    public AbstractChromaDevice(ChromaConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void setEffect(ChromaEffect effect) {
        this.currentEffect = effect;

        if (effect instanceof TimedChromaEffect) {
            this.currentEffectStartTime = -1;
            this.scheduledTask = configuration.executorService().scheduleAtFixedRate(() -> {
                if (currentEffect == effect) {
                    if (((TimedChromaEffect) effect).duration() <= -1
                            || System.currentTimeMillis() <= (currentEffectStartTime + ((TimedChromaEffect) effect).duration())) {
                        effect.apply(this);
                    }
                } else {
                    this.clearEffect();
                    this.scheduledTask.cancel(true);
                    this.scheduledTask = null;
                    this.currentEffect = null;
                    this.currentEffectStartTime = -1;
                }
            }, 0, ((TimedChromaEffect) effect).period(), TimeUnit.MILLISECONDS);
        } else {
            effect.apply(this);
        }
    }

    @Override
    public ChromaEffect getCurrentEffect() {
        return currentEffect;
    }

    public ChromaConfiguration getConfiguration() {
        return configuration;
    }

    public abstract void clearEffect();
}
