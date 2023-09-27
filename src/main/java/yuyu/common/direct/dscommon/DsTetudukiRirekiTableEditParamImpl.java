package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKanri;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ手続履歴TBL編集Param実装クラス
 */
public class DsTetudukiRirekiTableEditParamImpl implements DsTetudukiRirekiTableEditParam {

    private String dskokno;

    private String henkousikibetukey;

    private BizDate syoriYmd;

    private C_DsSyoriKbn dssyorikbn;

    private C_YouhiKbn henkouRrkYouhi;

    private MT_DsKokyakuKanri dsKokyakuKanri;

    private MT_BAK_DsKokyakuKanri bakDsKokyakuKanri;

    @Override
    public String getDskokno() {
        return dskokno;
    }

    @Override
    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

    @Override
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    @Override
    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    @Override
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Override
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    @Override
    public C_DsSyoriKbn getDssyorikbn() {
        return dssyorikbn;
    }

    @Override
    public void setDssyorikbn(C_DsSyoriKbn pDssyorikbn) {
        dssyorikbn = pDssyorikbn;
    }

    @Override
    public C_YouhiKbn getHenkouRrkYouhi() {
        return henkouRrkYouhi;
    }

    @Override
    public void setHenkouRrkYouhi(C_YouhiKbn pHenkouRrkYouhi) {
        henkouRrkYouhi = pHenkouRrkYouhi;
    }

    @Override
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return dsKokyakuKanri;
    }

    @Override
    public void setDsKokyakuKanri(MT_DsKokyakuKanri pDsKokyakuKanri) {
        dsKokyakuKanri = pDsKokyakuKanri;
    }

    @Override
    public MT_BAK_DsKokyakuKanri getBakDsKokyakuKanri() {
        return bakDsKokyakuKanri;
    }

    @Override
    public void setBakDsKokyakuKanri(MT_BAK_DsKokyakuKanri pBakDsKokyakuKanri) {
        bakDsKokyakuKanri = pBakDsKokyakuKanri;
    }

}
