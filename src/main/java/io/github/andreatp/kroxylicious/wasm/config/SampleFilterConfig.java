package io.github.andreatp.kroxylicious.wasm.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Jackson configuration object for both the sample filters.<br />
 * Both filters perform the same transformation process (though on different types of messages and at
 * different points), only replacing one configured String value with another single configured String value,
 * meaning they can share a single configuration class.<br />
 * <br />
 * This configuration class accepts one String argument: the name of the wasm module to be loaded
 * replaced with.
 */
public class SampleFilterConfig {
    private String replacerModule;

    /**
     * Empty constructor for Jackson serialization
     */
    public SampleFilterConfig() {
        replacerModule = null;
    }

    /**
     * @param replacerModule the WASM module to be loaded
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SampleFilterConfig(@JsonProperty(required = true) String replacerModule) {
        this.replacerModule = replacerModule;
    }

    /**
     * Returns the configured replacer module
     */
    public String getReplacerModule() {
        return replacerModule;
    }
}
