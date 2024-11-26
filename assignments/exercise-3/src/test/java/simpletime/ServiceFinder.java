package simpletime;

import java.util.ServiceLoader;
import java.util.Optional;
import static org.assertj.core.api.Assumptions.assumeThat;
import simpletimeapi.AbstractSimpleTimeFactory;

/**
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class ServiceFinder {
        
    /**
     * Try to find the factory provided by this module.
     *
     * @return an AbstractSimpleTimeFactory implementing object
     */
    public static AbstractSimpleTimeFactory getFactory() {
        Optional<AbstractSimpleTimeFactory> findFirst = ServiceLoader.load(AbstractSimpleTimeFactory.class ).findFirst();
        assumeThat( findFirst ).as("Factory service not found").isNotEmpty();
        return findFirst.get();
    }
}
