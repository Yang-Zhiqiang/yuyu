package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.db.entity.BM_ChkKykDairitenTuusanS;
import yuyu.def.db.mapping.GenBM_ChkKykDairitenTuusanS;
import yuyu.def.db.meta.GenQBM_ChkKykDairitenTuusanS;
import yuyu.def.db.meta.QBM_ChkKykDairitenTuusanS;

/**
 * 契約者同一代理店通算Ｓチェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKykDairitenTuusanS}</td><td colspan="3">契約者同一代理店通算Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKihonssyuruikbn kihonssyuruikbn}</td><td>基本Ｓ種類区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>gnds</td><td>限度Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkKykDairitenTuusanS
 * @see     GenBM_ChkKykDairitenTuusanS
 * @see     QBM_ChkKykDairitenTuusanS
 * @see     GenQBM_ChkKykDairitenTuusanS
 */
public class PKBM_ChkKykDairitenTuusanS extends AbstractExDBPrimaryKey<BM_ChkKykDairitenTuusanS, PKBM_ChkKykDairitenTuusanS> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkKykDairitenTuusanS() {
    }

    public PKBM_ChkKykDairitenTuusanS(C_KihonssyuruiKbn pKihonssyuruikbn) {
        kihonssyuruikbn = pKihonssyuruikbn;
    }

    @Transient
    @Override
    public Class<BM_ChkKykDairitenTuusanS> getEntityClass() {
        return BM_ChkKykDairitenTuusanS.class;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn;

    @org.hibernate.annotations.Type(type="UserType_C_KihonssyuruiKbn")
    public C_KihonssyuruiKbn getKihonssyuruikbn() {
        return kihonssyuruikbn;
    }

    public void setKihonssyuruikbn(C_KihonssyuruiKbn pKihonssyuruikbn) {
        kihonssyuruikbn = pKihonssyuruikbn;
    }

}