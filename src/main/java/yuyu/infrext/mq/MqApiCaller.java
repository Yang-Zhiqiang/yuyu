package yuyu.infrext.mq;

/**
 * MqApi呼出基盤インターフェース
 */

public class MqApiCaller extends MqApiCallerImpl {

    @Override
    public String call(String SyoriCd, String UserData, String SosikiCd, String OperatorId) {
        return super.call(SyoriCd, UserData, SosikiCd, OperatorId);
    }

    @Override
    public String call(String SyoriCd, String UserData) {
        return super.call(SyoriCd, UserData);
    }
}
