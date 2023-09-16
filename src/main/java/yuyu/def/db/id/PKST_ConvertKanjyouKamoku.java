package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;
import yuyu.def.db.mapping.GenST_ConvertKanjyouKamoku;
import yuyu.def.db.meta.GenQST_ConvertKanjyouKamoku;
import yuyu.def.db.meta.QST_ConvertKanjyouKamoku;

/**
 * 勘定科目変換テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_ConvertKanjyouKamoku}</td><td colspan="3">勘定科目変換テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>convertedkanjyoukmkcd</td><td>変換後勘定科目コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kanjyoukmkcd C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_ConvertKanjyouKamoku
 * @see     GenST_ConvertKanjyouKamoku
 * @see     QST_ConvertKanjyouKamoku
 * @see     GenQST_ConvertKanjyouKamoku
 */
public class PKST_ConvertKanjyouKamoku extends AbstractExDBPrimaryKey<ST_ConvertKanjyouKamoku, PKST_ConvertKanjyouKamoku> {

    private static final long serialVersionUID = 1L;

    public PKST_ConvertKanjyouKamoku() {
    }

    public PKST_ConvertKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn) {
        kanjyoukmkcd = pKanjyoukmkcd;
        taisyakukbn = pTaisyakukbn;
    }

    @Transient
    @Override
    public Class<ST_ConvertKanjyouKamoku> getEntityClass() {
        return ST_ConvertKanjyouKamoku.class;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @org.hibernate.annotations.Type(type="UserType_C_Kanjyoukmkcd")
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }
    private C_TaisyakuKbn taisyakukbn;

    @org.hibernate.annotations.Type(type="UserType_C_TaisyakuKbn")
    public C_TaisyakuKbn getTaisyakukbn() {
        return taisyakukbn;
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        taisyakukbn = pTaisyakukbn;
    }

}