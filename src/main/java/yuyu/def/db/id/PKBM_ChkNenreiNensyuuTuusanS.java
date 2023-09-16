package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkNenreiNensyuuTuusanS;
import yuyu.def.db.mapping.GenBM_ChkNenreiNensyuuTuusanS;
import yuyu.def.db.meta.GenQBM_ChkNenreiNensyuuTuusanS;
import yuyu.def.db.meta.QBM_ChkNenreiNensyuuTuusanS;

/**
 * 年齢年収制限通算限度Ｓチェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNenreiNensyuuTuusanS}</td><td colspan="3">年齢年収制限通算限度Ｓチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknfromnensyuu hhknfromnensyuu}</td><td>被保険者年収区分自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhkntonensyuu hhkntonensyuu}</td><td>被保険者年収区分至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gnds1</td><td>限度Ｓ１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gnds2</td><td>限度Ｓ２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>itijibrgnds1</td><td>一時払限度Ｓ１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>itijibrgnds2</td><td>一時払限度Ｓ２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkNenreiNensyuuTuusanS
 * @see     GenBM_ChkNenreiNensyuuTuusanS
 * @see     QBM_ChkNenreiNensyuuTuusanS
 * @see     GenQBM_ChkNenreiNensyuuTuusanS
 */
public class PKBM_ChkNenreiNensyuuTuusanS extends AbstractExDBPrimaryKey<BM_ChkNenreiNensyuuTuusanS, PKBM_ChkNenreiNensyuuTuusanS> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkNenreiNensyuuTuusanS() {
    }

    public PKBM_ChkNenreiNensyuuTuusanS(
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        Integer pHhknfromnensyuu,
        Integer pHhkntonensyuu
    ) {
        hhknfromnen = pHhknfromnen;
        hhkntonen = pHhkntonen;
        hhknfromnensyuu = pHhknfromnensyuu;
        hhkntonensyuu = pHhkntonensyuu;
    }

    @Transient
    @Override
    public Class<BM_ChkNenreiNensyuuTuusanS> getEntityClass() {
        return BM_ChkNenreiNensyuuTuusanS.class;
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
    private Integer hhknfromnensyuu;

    public Integer getHhknfromnensyuu() {
        return hhknfromnensyuu;
    }

    public void setHhknfromnensyuu(Integer pHhknfromnensyuu) {
        hhknfromnensyuu = pHhknfromnensyuu;
    }
    private Integer hhkntonensyuu;

    public Integer getHhkntonensyuu() {
        return hhkntonensyuu;
    }

    public void setHhkntonensyuu(Integer pHhkntonensyuu) {
        hhkntonensyuu = pHhkntonensyuu;
    }

}