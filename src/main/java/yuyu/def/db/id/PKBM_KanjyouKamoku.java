package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.mapping.GenBM_KanjyouKamoku;
import yuyu.def.db.meta.GenQBM_KanjyouKamoku;
import yuyu.def.db.meta.QBM_KanjyouKamoku;

/**
 * 勘定科目マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KanjyouKamoku}</td><td colspan="3">勘定科目マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>denkanjokamokucd</td><td>伝票用勘定科目コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjyoukmknm</td><td>勘定科目名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jigyouhiutiwakecd</td><td>事業費内訳コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jigyouhiutiwakenm</td><td>事業費内訳名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hjybyouhyj</td><td>補助簿要表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>hjybtantositucd</td><td>補助簿統括担当室コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hjybruigkteiseiumukbn</td><td>補助簿累計額訂正有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kanjyoukmkgroupkbn</td><td>勘定科目グループ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KanjyoukmkgroupKbn C_KanjyoukmkgroupKbn}</td></tr>
 *  <tr><td>kbnkeiriyouhi</td><td>区分経理要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_KanjyouKamoku
 * @see     GenBM_KanjyouKamoku
 * @see     QBM_KanjyouKamoku
 * @see     GenQBM_KanjyouKamoku
 */
public class PKBM_KanjyouKamoku extends AbstractExDBPrimaryKey<BM_KanjyouKamoku, PKBM_KanjyouKamoku> {

    private static final long serialVersionUID = 1L;

    public PKBM_KanjyouKamoku() {
    }

    public PKBM_KanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    @Transient
    @Override
    public Class<BM_KanjyouKamoku> getEntityClass() {
        return BM_KanjyouKamoku.class;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @org.hibernate.annotations.Type(type="UserType_C_Kanjyoukmkcd")
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

}