package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BunsyoSyubetuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_BunsyonoSettei;
import yuyu.def.db.mapping.GenBM_BunsyonoSettei;
import yuyu.def.db.meta.GenQBM_BunsyonoSettei;
import yuyu.def.db.meta.QBM_BunsyonoSettei;

/**
 * 文書番号設定マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_BunsyonoSettei}</td><td colspan="3">文書番号設定マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBunsyosyubetukbn bunsyosyubetukbn}</td><td>文書種別区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_BunsyoSyubetuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tekiyouYmdFrom</td><td>適用年月日（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tekiyouYmdTo</td><td>適用年月日（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bunsyono</td><td>文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siorino</td><td>しおり番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_BunsyonoSettei
 * @see     GenBM_BunsyonoSettei
 * @see     QBM_BunsyonoSettei
 * @see     GenQBM_BunsyonoSettei
 */
public class PKBM_BunsyonoSettei extends AbstractExDBPrimaryKey<BM_BunsyonoSettei, PKBM_BunsyonoSettei> {

    private static final long serialVersionUID = 1L;

    public PKBM_BunsyonoSettei() {
    }

    public PKBM_BunsyonoSettei(
        C_BunsyoSyubetuKbn pBunsyosyubetukbn,
        C_AisyoumeiKbn pAisyoumeikbn,
        C_Channelcd pChannelcd,
        String pOyadrtencd,
        Integer pRenno
    ) {
        bunsyosyubetukbn = pBunsyosyubetukbn;
        aisyoumeikbn = pAisyoumeikbn;
        channelcd = pChannelcd;
        oyadrtencd = pOyadrtencd;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<BM_BunsyonoSettei> getEntityClass() {
        return BM_BunsyonoSettei.class;
    }

    private C_BunsyoSyubetuKbn bunsyosyubetukbn;

    @org.hibernate.annotations.Type(type="UserType_C_BunsyoSyubetuKbn")
    public C_BunsyoSyubetuKbn getBunsyosyubetukbn() {
        return bunsyosyubetukbn;
    }

    public void setBunsyosyubetukbn(C_BunsyoSyubetuKbn pBunsyosyubetukbn) {
        bunsyosyubetukbn = pBunsyosyubetukbn;
    }
    private C_AisyoumeiKbn aisyoumeikbn;

    @org.hibernate.annotations.Type(type="UserType_C_AisyoumeiKbn")
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }
    private C_Channelcd channelcd;

    @org.hibernate.annotations.Type(type="UserType_C_Channelcd")
    public C_Channelcd getChannelcd() {
        return channelcd;
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        channelcd = pChannelcd;
    }
    private String oyadrtencd;

    public String getOyadrtencd() {
        return oyadrtencd;
    }

    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}