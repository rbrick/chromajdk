package io.rcw.chromajdk.sdk.internals.corsair;

import io.rcw.chromajdk.sdk.AbstractChromaDevice;
import io.rcw.chromajdk.sdk.Brand;
import io.rcw.chromajdk.sdk.ChromaConfiguration;

public abstract class CorsairChromaDevice extends AbstractChromaDevice {

    public CorsairChromaDevice(ChromaConfiguration configuration) {
        super(configuration);
    }

    @Override
    public Brand getBrand() {
        return Brand.CORSAIR;
    }
}
