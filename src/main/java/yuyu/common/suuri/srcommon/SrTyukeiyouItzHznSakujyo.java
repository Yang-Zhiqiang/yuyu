package yuyu.common.suuri.srcommon;

import javax.inject.Inject;

import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理 数理共通　中継用一時保存テーブル削除クラス
 */
public class SrTyukeiyouItzHznSakujyo {

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public SrTyukeiyouItzHznSakujyo() {
        super();
    }

    public void deleteItzHznTable(BzBatchParam pBzBatchParam) {

        String ibKakutyoujobcd = pBzBatchParam.getIbKakutyoujobcd();

        if( SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_HY.equals(ibKakutyoujobcd) ||
            SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_HY.equals(ibKakutyoujobcd) ){
            srCommonKinouDao.deleteStHoyuuMeisaiTyukeiyouItzHzn();
        }
        else if( SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_ID.equals(ibKakutyoujobcd) ||
            SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_ID.equals(ibKakutyoujobcd) ){

            srCommonKinouDao.deleteStIdouMeisaiTyukeiyouItzHzn(ibKakutyoujobcd.substring(0, 4));
        }
        else if( SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_BK.equals(ibKakutyoujobcd)) {
            srCommonKinouDao.deleteStIdouMeisaiTyukeiyouItzHzn(ibKakutyoujobcd.substring(0, 4));
        }
        else if( SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_DSHRTOUKEI.equals(ibKakutyoujobcd) ||
            SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_DSHRTOUKEI.equals(ibKakutyoujobcd) ||
            SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_DSHRTOUKEI.equals(ibKakutyoujobcd) ){
            srCommonKinouDao.deleteStDshrTukiTyukeiyouItzHzn();
        }
    }
}
