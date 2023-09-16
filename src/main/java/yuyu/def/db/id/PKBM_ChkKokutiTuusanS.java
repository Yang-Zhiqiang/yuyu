package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.db.entity.BM_ChkKokutiTuusanS;
import yuyu.def.db.mapping.GenBM_ChkKokutiTuusanS;
import yuyu.def.db.meta.GenQBM_ChkKokutiTuusanS;
import yuyu.def.db.meta.QBM_ChkKokutiTuusanS;

/**
 * 告知扱通算限度Ｓチェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKokutiTuusanS}</td><td colspan="3">告知扱通算限度Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKijikbn kijikbn}</td><td>記事区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KijiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIktkktkbnfrom iktkktkbnfrom}</td><td>一括告知区分自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIktkktkbnto iktkktkbnto}</td><td>一括告知区分至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gnds1</td><td>限度Ｓ１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gnds2</td><td>限度Ｓ２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gnds3</td><td>限度Ｓ３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkKokutiTuusanS
 * @see     GenBM_ChkKokutiTuusanS
 * @see     QBM_ChkKokutiTuusanS
 * @see     GenQBM_ChkKokutiTuusanS
 */
public class PKBM_ChkKokutiTuusanS extends AbstractExDBPrimaryKey<BM_ChkKokutiTuusanS, PKBM_ChkKokutiTuusanS> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkKokutiTuusanS() {
    }

    public PKBM_ChkKokutiTuusanS(
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        C_KijiKbn pKijikbn,
        Integer pIktkktkbnfrom,
        Integer pIktkktkbnto
    ) {
        hhknfromnen = pHhknfromnen;
        hhkntonen = pHhkntonen;
        kijikbn = pKijikbn;
        iktkktkbnfrom = pIktkktkbnfrom;
        iktkktkbnto = pIktkktkbnto;
    }

    @Transient
    @Override
    public Class<BM_ChkKokutiTuusanS> getEntityClass() {
        return BM_ChkKokutiTuusanS.class;
    }

    private BizNumber hhknfromnen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHhknfromnen() {
        return hhknfromnen;
    }

    public void setHhknfromnen(BizNumber pHhknfromnen) {
        hhknfromnen = pHhknfromnen;
    }
    private BizNumber hhkntonen;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHhkntonen() {
        return hhkntonen;
    }

    public void setHhkntonen(BizNumber pHhkntonen) {
        hhkntonen = pHhkntonen;
    }
    private C_KijiKbn kijikbn;

    @org.hibernate.annotations.Type(type="UserType_C_KijiKbn")
    public C_KijiKbn getKijikbn() {
        return kijikbn;
    }

    public void setKijikbn(C_KijiKbn pKijikbn) {
        kijikbn = pKijikbn;
    }
    private Integer iktkktkbnfrom;

    public Integer getIktkktkbnfrom() {
        return iktkktkbnfrom;
    }

    public void setIktkktkbnfrom(Integer pIktkktkbnfrom) {
        iktkktkbnfrom = pIktkktkbnfrom;
    }
    private Integer iktkktkbnto;

    public Integer getIktkktkbnto() {
        return iktkktkbnto;
    }

    public void setIktkktkbnto(Integer pIktkktkbnto) {
        iktkktkbnto = pIktkktkbnto;
    }

}