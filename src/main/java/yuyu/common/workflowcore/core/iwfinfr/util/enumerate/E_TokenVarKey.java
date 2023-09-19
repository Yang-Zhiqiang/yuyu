package yuyu.common.workflowcore.core.iwfinfr.util.enumerate;

/**
 * トークン変数のキーです。<br />
 */
public enum E_TokenVarKey {

    JSON_OBJECT,
    KOUTEI_KAISIDAY,
    KOUTEI_KANRYOUDAY,
    SYORI_STATUS,
    LOCK,
    LOCK_TIME,
    AUTO_CREATE_FLOWID,
    REQUEST_ID,
    RULE_SERVICE_URL,
    RULE_CONDITIONNAME,
    RULE_CONDITION,
    ;

    E_TokenVarKey(){
        this.key = this.toString();
    }
    public String key;

}
