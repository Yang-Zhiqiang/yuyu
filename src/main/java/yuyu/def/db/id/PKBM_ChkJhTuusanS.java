package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkJhTuusanS;
import yuyu.def.db.mapping.GenBM_ChkJhTuusanS;
import yuyu.def.db.meta.GenQBM_ChkJhTuusanS;
import yuyu.def.db.meta.QBM_ChkJhTuusanS;

/**
 * 通算限度Ｓ事方書チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkJhTuusanS}</td><td colspan="3">通算限度Ｓ事方書チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gnds1</td><td>限度Ｓ１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gnds2</td><td>限度Ｓ２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gnds3</td><td>限度Ｓ３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gnds4</td><td>限度Ｓ４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gnds5</td><td>限度Ｓ５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>oldkijyungnds1</td><td>旧基準限度Ｓ１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>oldkijyungnds2</td><td>旧基準限度Ｓ２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkJhTuusanS
 * @see     GenBM_ChkJhTuusanS
 * @see     QBM_ChkJhTuusanS
 * @see     GenQBM_ChkJhTuusanS
 */
public class PKBM_ChkJhTuusanS extends AbstractExDBPrimaryKey<BM_ChkJhTuusanS, PKBM_ChkJhTuusanS> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkJhTuusanS() {
    }

    public PKBM_ChkJhTuusanS(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        hhknfromnen = pHhknfromnen;
        hhkntonen = pHhkntonen;
    }

    @Transient
    @Override
    public Class<BM_ChkJhTuusanS> getEntityClass() {
        return BM_ChkJhTuusanS.class;
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

}