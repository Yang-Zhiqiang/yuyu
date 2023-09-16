package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkJhNenreiNensyuuTuusanS;
import yuyu.def.db.mapping.GenBM_ChkJhNenreiNensyuuTuusanS;
import yuyu.def.db.meta.GenQBM_ChkJhNenreiNensyuuTuusanS;
import yuyu.def.db.meta.QBM_ChkJhNenreiNensyuuTuusanS;

/**
 * 年齢年収制限通算限度Ｓ事方書チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkJhNenreiNensyuuTuusanS}</td><td colspan="3">年齢年収制限通算限度Ｓ事方書チェックマスタ</td></tr>
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
 * @see     BM_ChkJhNenreiNensyuuTuusanS
 * @see     GenBM_ChkJhNenreiNensyuuTuusanS
 * @see     QBM_ChkJhNenreiNensyuuTuusanS
 * @see     GenQBM_ChkJhNenreiNensyuuTuusanS
 */
public class PKBM_ChkJhNenreiNensyuuTuusanS extends AbstractExDBPrimaryKey<BM_ChkJhNenreiNensyuuTuusanS, PKBM_ChkJhNenreiNensyuuTuusanS> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkJhNenreiNensyuuTuusanS() {
    }

    public PKBM_ChkJhNenreiNensyuuTuusanS(
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
    public Class<BM_ChkJhNenreiNensyuuTuusanS> getEntityClass() {
        return BM_ChkJhNenreiNensyuuTuusanS.class;
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