package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 契約保全共通 解約共通チェックBeanクラス
 */
public class CheckKaiyakuBean implements Serializable  {

    private static final long serialVersionUID = 1L;

    private BizDate syoruiukeYmd;

    private BizDate syukykYmd;

    private BizDate yendthnkYmd;

    private BizDate syoriYmd;

    private IT_KykKihon kykKihon;

    private IT_AnsyuKihon AnsyuKihon;

    public BizDate getSyoruiukeYmd() {
        return syoruiukeYmd;
    }

    public void setSyoruiukeYmd(BizDate pSyoruiukeYmd) {
        syoruiukeYmd = pSyoruiukeYmd;
    }

    public BizDate getSyukykYmd() {
        return syukykYmd;
    }

    public void setSyukykYmd(BizDate pSyukykYmd) {
        syukykYmd = pSyukykYmd;
    }

    public BizDate getYendthnkYmd() {
        return yendthnkYmd;
    }

    public void setYendthnkYmd(BizDate pYendthnkYmd) {
        yendthnkYmd = pYendthnkYmd;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    public IT_AnsyuKihon getAnsyuKihon() {
        return AnsyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pAnsyuKihon) {
        AnsyuKihon = pAnsyuKihon;
    }

}
