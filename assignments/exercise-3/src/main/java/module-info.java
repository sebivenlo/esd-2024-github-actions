/**
 * ALDA Assignment SimpleTime Implementation.
 */
module simpletimeimpl {
    requires simpletimeapi;
    uses simpletimeapi.AbstractSimpleTimeFactory;
    provides simpletimeapi.AbstractSimpleTimeFactory with simpletime.SimpleTimeFactory;
}
