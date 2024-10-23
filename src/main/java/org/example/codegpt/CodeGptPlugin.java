package org.example.codegpt;

import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

/**
 * @author: Ryan Hong
 */
public class CodeGptPlugin extends Plugin {

    /**
     * Constructor to be used by plugin manager for plugin instantiation. Your plugins have to
     * provide constructor with this exact signature to be successfully loaded by manager.
     *
     * @param wrapper
     */
    public CodeGptPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }
}
