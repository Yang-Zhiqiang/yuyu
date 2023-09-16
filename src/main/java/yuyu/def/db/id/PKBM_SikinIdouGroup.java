package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.mapping.GenBM_SikinIdouGroup;
import yuyu.def.db.meta.GenQBM_SikinIdouGroup;
import yuyu.def.db.meta.QBM_SikinIdouGroup;

/**
 * 資金移動グループマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SikinIdouGroup}</td><td colspan="3">資金移動グループマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSegcd segcd}</td><td>セグメントコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>sikinidougroupkbn</td><td>資金移動グループ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidougroupKbn C_SikinidougroupKbn}</td></tr>
 * </table>
 * @see     BM_SikinIdouGroup
 * @see     GenBM_SikinIdouGroup
 * @see     QBM_SikinIdouGroup
 * @see     GenQBM_SikinIdouGroup
 */
public class PKBM_SikinIdouGroup extends AbstractExDBPrimaryKey<BM_SikinIdouGroup, PKBM_SikinIdouGroup> {

    private static final long serialVersionUID = 1L;

    public PKBM_SikinIdouGroup() {
    }

    public PKBM_SikinIdouGroup(C_Segcd pSegcd) {
        segcd = pSegcd;
    }

    @Transient
    @Override
    public Class<BM_SikinIdouGroup> getEntityClass() {
        return BM_SikinIdouGroup.class;
    }

    private C_Segcd segcd;

    @org.hibernate.annotations.Type(type="UserType_C_Segcd")
    public C_Segcd getSegcd() {
        return segcd;
    }

    public void setSegcd(C_Segcd pSegcd) {
        segcd = pSegcd;
    }

}