package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;

/**
 * 契約保全 契約保全共通 手続履歴TBL編集パラメータ
 */
public class EditTtdkRirekiTblParam {

    private KhozenCommonParam kCParm = null;

    private String syoNo = "";

    private BizDate syoriYmd;

    private C_UmuKbn shrSyousaiUmu = C_UmuKbn.NONE;

    private C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

    private C_HonninKakninKekkaKbn honninKakninKekkaKbn = C_HonninKakninKekkaKbn.BLNK;

    private String sysTime = "";

    private C_YouhiKbn henkouRrkYouhi = C_YouhiKbn.HUYOU;

    private String smbcKanriId = "";

    private String nayoseKihontblSkbtKey = "";

    private String kouteiKanriId = "";

    private String youkyuuNo = "";

    IT_NyuukinKakusyouData nyuukinKakusyouData = null;

    @Inject
    private static Logger logger;

    public EditTtdkRirekiTblParam() {
        super();
    }

    public KhozenCommonParam getCommonParam() {
        return kCParm;
    }

    public void setCommonParam(KhozenCommonParam pKCParm) {
        kCParm = pKCParm;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public BizDate getSyoriYmd(){
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public C_UmuKbn getShrSyousaiUmu() {
        return shrSyousaiUmu;
    }

    public void setShrSyousaiUmu(C_UmuKbn pShrSyousaiUmu) {
        shrSyousaiUmu = pShrSyousaiUmu;
    }

    public C_SyoriKbn getSyoriKbn() {
        return syoriKbn;
    }

    public void setSyoriKbn(C_SyoriKbn pSyoriKbn) {
        syoriKbn = pSyoriKbn;
    }

    public C_HonninKakninKekkaKbn getHonninkakkekka() {
        return honninKakninKekkaKbn;
    }

    public void setHonninkakkekka(C_HonninKakninKekkaKbn pHonninkakkekka) {
        honninKakninKekkaKbn = pHonninkakkekka;
    }

    public String getSysTime() {
        return sysTime;
    }

    public void setSysTime(String pSysTime) {
        sysTime = pSysTime;
    }

    public C_YouhiKbn getHenkouRrkYouhi() {
        return henkouRrkYouhi;
    }

    public void setHenkouRrkYouhi(C_YouhiKbn pHenkouRrkYouhi) {
        henkouRrkYouhi = pHenkouRrkYouhi;
    }

    public String getSmbcKanriId() {
        return smbcKanriId;
    }

    public void setSmbcKanriId(String pSmbcKanriId) {
        smbcKanriId = pSmbcKanriId;
    }

    public String getNayoseKihontblSkbtKey() {
        return nayoseKihontblSkbtKey;
    }

    public void setNayoseKihontblSkbtKey(String pNayoseKihontblSkbtkey) {
        nayoseKihontblSkbtKey = pNayoseKihontblSkbtkey;
    }

    public String getKouteiKanriId() {
        return kouteiKanriId;
    }

    public void setKouteiKanriId(String pKouteiKanriId) {
        kouteiKanriId = pKouteiKanriId;
    }

    public String getYoukyuuNo() {
        return youkyuuNo;
    }

    public void setYoukyuuNo(String pYoukyuuNo) {
        youkyuuNo = pYoukyuuNo;
    }

    public IT_NyuukinKakusyouData getNyuukinKakusyouData() {
        return nyuukinKakusyouData;
    }

    public void setNyuukinKakusyouData(IT_NyuukinKakusyouData pNyuukinKakusyouData) {
        nyuukinKakusyouData = pNyuukinKakusyouData;
    }

    public void debug() {
        if (logger.isDebugEnabled()) {

            KhozenCommonParam kcParm = this.getCommonParam();
            logger.debug("▽ 手続履歴作成パラメータ");
            logger.debug("｜ 証券番号         = [" + this.syoNo             + "]");
            logger.debug("｜ 処理日           = [" + this.syoriYmd          + "]");
            logger.debug("｜ 支払詳細有無     = [" + this.shrSyousaiUmu     + "]");
            logger.debug("｜ 処理区分         = [" + this.syoriKbn          + "]");
            logger.debug("｜ システム時間     = [" + this.sysTime           + "]");
            logger.debug("｜ 変更履歴作成要否 = [" + this.henkouRrkYouhi    + "]");
            logger.debug("｜ 名寄せ基本テーブル識別キー   = [" + this.nayoseKihontblSkbtKey  + "]");
            logger.debug("｜ 工程管理ＩＤ     = [" + this.kouteiKanriId     + "]");
            logger.debug("｜ 要求通番         = [" + this.youkyuuNo         + "]");
            logger.debug("｜ ▽ 契約保全共通パラメータ");
            logger.debug("｜ ｜ 識別キー      = [" + kcParm.getSikibetuKey(syoNo) + "]");
            logger.debug("｜ ｜ 機能ID        = [" + kcParm.getFunctionId()  + "]");
            logger.debug("｜ ｜ ユーザID      = [" + kcParm.getUserID()      + "]");
            logger.debug("｜ △");
            if (nyuukinKakusyouData != null) {

                logger.debug("｜ ▽ 入金確証データテーブルエンティティ");
                logger.debug("｜ ｜ 区分キー      = [" + nyuukinKakusyouData.getKbnkey() + "]");
                logger.debug("｜ ｜ 入金確証番号  = [" + nyuukinKakusyouData.getNyuukinkakusyouno() + "]");
                logger.debug("｜ ｜ 証券番号      = [" + nyuukinKakusyouData.getSyono() + "]");
                logger.debug("｜ △");
            }
            else {

                logger.debug("｜ 入金確証データテーブルエンティティ   = [" + this.nyuukinKakusyouData + "]");
            }
            logger.debug("△");
        }
    }
}
