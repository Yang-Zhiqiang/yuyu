package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKanri;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ手続履歴TBL編集Paramインターフェース
 */
public interface DsTetudukiRirekiTableEditParam {

    void setDskokno(String pDskokno);

    String getDskokno();

    void setHenkousikibetukey(String pHenkousikibetukey);

    String getHenkousikibetukey();

    void setSyoriYmd(BizDate pSyoriYmd);

    BizDate getSyoriYmd();

    void setDssyorikbn(C_DsSyoriKbn pDssyorikbn);

    C_DsSyoriKbn getDssyorikbn();

    void setHenkouRrkYouhi(C_YouhiKbn pHenkouRrkYouhi);

    C_YouhiKbn getHenkouRrkYouhi();

    void setDsKokyakuKanri(MT_DsKokyakuKanri pDsKokyakuKanri);

    MT_DsKokyakuKanri getDsKokyakuKanri();

    void setBakDsKokyakuKanri(MT_BAK_DsKokyakuKanri pBakDsKokyakuKanri);

    MT_BAK_DsKokyakuKanri getBakDsKokyakuKanri();
}
