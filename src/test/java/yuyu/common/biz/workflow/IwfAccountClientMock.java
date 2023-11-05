package yuyu.common.biz.workflow;

import yuyu.common.biz.workflow.io.account.DelImageAuthorityInBean;
import yuyu.common.biz.workflow.io.account.GetImageAuthorityInBean;
import yuyu.common.biz.workflow.io.account.UpdImageAuthorityInBean;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority.WSDelImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority.WSGetImageAuthorityResponse;
import yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority.WSUpdImageAuthorityResponse;


public class IwfAccountClientMock extends IwfAccountClient {
    public static String caller = null;
    public static String mode = null;

    @Override
    public WSGetImageAuthorityResponse execGetImageAuthority(GetImageAuthorityInBean inBean) {
        if("Test".equals(caller)) {
            WSGetImageAuthorityResponse response = new WSGetImageAuthorityResponse();

            switch(mode) {
                case "25-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "25-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0003");
                    response.setSyousaimsg("稼働時間外エラーか、認証エラーが発生しました。");
                    break;
                case "25-05":
                    response.setTorikomiSyoruiCds(new String[] {"wf001","wf003","wf002","hz001","hz003","hz002","nk001","nk003","nk002"});
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "25-06":
                    response.setTorikomiSyoruiCds(new String[] {"wf001","hz001","nk001"});
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "25-08":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "25-09":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "25-10":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "25-11":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "25-12":
                    response.setTorikomiSyoruiCds(new String[] {"wf001","wf003","wf002","hz001","hz003","hz002","nk001","nk003","nk002"});
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "25-13":
                    response.setTorikomiSyoruiCds(new String[] {"wf001","hz001","nk001"});
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
                case "25-14":
                    response.setTorikomiSyoruiCds(new String[] {"wf001","hz001","nk001"});
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;

                case "33-01":
                    response.setTorikomiSyoruiCds(new String[] {"wf001","hz001","nk001"});
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;

                case "33-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "33-03":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;
                case "33-04":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF9004");
                    response.setSyousaimsg("データ整合性エラー。");
                    break;

                case "33-05":
                    response.setTorikomiSyoruiCds(new String[] {"wf001","hz001","nk001"});
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;

                default:
                    response.setTorikomiSyoruiCds(new String[] {"wf001","wf003","wf002"});
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.execGetImageAuthority(inBean);
        }
    }

    @Override
    public WSUpdImageAuthorityResponse execUpdImageAuthority(UpdImageAuthorityInBean inBean) {
        if("Test".equals(caller)) {
            WSUpdImageAuthorityResponse response = new WSUpdImageAuthorityResponse();
            switch(mode) {
                case "26-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0001");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                case "26-02":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0001");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.execUpdImageAuthority(inBean);
        }
    }

    @Override
    public WSDelImageAuthorityResponse execDelImageAuthority(DelImageAuthorityInBean inBean) {
        if("Test".equals(caller)) {
            WSDelImageAuthorityResponse response = new WSDelImageAuthorityResponse();

            switch(mode) {
                case "27-01":
                    response.setKekkastatus("9");
                    response.setSyousaimsgcd("IWF0001");
                    response.setSyousaimsg("異常終了しました。");
                    break;
                default:
                    response.setKekkastatus("0");
                    response.setSyousaimsgcd("IWF0000");
                    response.setSyousaimsg("正常終了しました。");
                    break;
            }
            return response;
        } else {
            return super.execDelImageAuthority(inBean);
        }
    }
}
