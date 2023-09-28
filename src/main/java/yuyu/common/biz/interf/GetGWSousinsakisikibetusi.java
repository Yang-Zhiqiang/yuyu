package yuyu.common.biz.interf;

import javax.inject.Inject;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_GwdrtensikibetuKbn;

/**
 * 業務共通 インターフェイス GW送信先識別子取得
 */
public class GetGWSousinsakisikibetusi {

    @Inject
    private BizDomManager bizDomManager;

    public GetGWSousinsakisikibetusi() {
        super();
    }

    public String getGWSousinsakisikibetusi(C_GwdrtensikibetuKbn pGWDairitensikibetKbn) {

        String sousinsakisikibetusi = null;

        if (pGWDairitensikibetKbn == null) {
            throw new CommonBizAppException("GW送信先識別子取得エラー");
        }

//      List<BM_Channel> channelLst = bizDomManager.getChannelsByGwdrtensikibetukbn(pGWDairitensikibetKbn);
//
//      if (channelLst == null || channelLst.size() == 0 || channelLst.size() > 1) {
//          throw new CommonBizAppException("GW送信先識別子取得エラー");
//      }
//      sousinsakisikibetusi = channelLst.get(0).getGwsousinsakisikibetusi();

      return sousinsakisikibetusi;
  }
}
