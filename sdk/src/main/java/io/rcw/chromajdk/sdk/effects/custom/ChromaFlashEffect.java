package io.rcw.chromajdk.sdk.effects.custom;

import io.rcw.chromajdk.sdk.ChromaDevice;
import io.rcw.chromajdk.sdk.TimedChromaEffect;
import io.rcw.chromajdk.sdk.utils.IteratorUtils;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ChromaFlashEffect implements TimedChromaEffect {
    private Iterator<Color> colors;
    private long period;

    private AtomicBoolean showColor = new AtomicBoolean(true);


    public ChromaFlashEffect(Collection<Color> colors, long nextFlashTime, TimeUnit unit) {
        this.colors = IteratorUtils.cycle(colors);
        this.period = unit.toMillis(nextFlashTime);
    }

    @Override
    public void apply(ChromaDevice device) {
        if (showColor.get()) {
            showColor.set(false);
            device.setColor(colors.next());
        } else {
            showColor.set(true);
            device.clearEffect();
        }
    }

    @Override
    public long period() {
        return this.period;
    }

    @Override
    public long duration() {
        return -1;
    }
}
