package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BunsyoSyubetuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_BunsyonoSettei;
import yuyu.def.db.id.PKBM_BunsyonoSettei;
import yuyu.def.db.meta.GenQBM_BunsyonoSettei;
import yuyu.def.db.meta.QBM_BunsyonoSettei;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_BunsyoSyubetuKbn;
import yuyu.def.db.type.UserType_C_Channelcd;

/**
 * 文書番号設定マスタ テーブルのマッピング情報クラスで、 {@link BM_BunsyonoSettei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_BunsyonoSettei}</td><td colspan="3">文書番号設定マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBunsyosyubetukbn bunsyosyubetukbn}</td><td>文書種別区分</td><td align="center">{@link PKBM_BunsyonoSettei ○}</td><td align="center">V</td><td>{@link C_BunsyoSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">{@link PKBM_BunsyonoSettei ○}</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">{@link PKBM_BunsyonoSettei ○}</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">{@link PKBM_BunsyonoSettei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKBM_BunsyonoSettei ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTekiyouYmdFrom tekiyouYmdFrom}</td><td>適用年月日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTekiyouYmdTo tekiyouYmdTo}</td><td>適用年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBunsyono bunsyono}</td><td>文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiorino siorino}</td><td>しおり番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_BunsyonoSettei
 * @see     PKBM_BunsyonoSettei
 * @see     QBM_BunsyonoSettei
 * @see     GenQBM_BunsyonoSettei
 */
@MappedSuperclass
@Table(name=GenBM_BunsyonoSettei.TABLE_NAME)
@IdClass(value=PKBM_BunsyonoSettei.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_AisyoumeiKbn", typeClass=UserType_C_AisyoumeiKbn.class),
    @TypeDef(name="UserType_C_BunsyoSyubetuKbn", typeClass=UserType_C_BunsyoSyubetuKbn.class),
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class)
})
public abstract class GenBM_BunsyonoSettei extends AbstractExDBEntity<BM_BunsyonoSettei, PKBM_BunsyonoSettei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_BunsyonoSettei";
    public static final String BUNSYOSYUBETUKBN         = "bunsyosyubetukbn";
    public static final String AISYOUMEIKBN             = "aisyoumeikbn";
    public static final String CHANNELCD                = "channelcd";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String RENNO                    = "renno";
    public static final String TEKIYOUYMDFROM           = "tekiyouYmdFrom";
    public static final String TEKIYOUYMDTO             = "tekiyouYmdTo";
    public static final String BUNSYONO                 = "bunsyono";
    public static final String SIORINO                  = "siorino";

    private final PKBM_BunsyonoSettei primaryKey;

    public GenBM_BunsyonoSettei() {
        primaryKey = new PKBM_BunsyonoSettei();
    }

    public GenBM_BunsyonoSettei(
        C_BunsyoSyubetuKbn pBunsyosyubetukbn,
        C_AisyoumeiKbn pAisyoumeikbn,
        C_Channelcd pChannelcd,
        String pOyadrtencd,
        Integer pRenno
    ) {
        primaryKey = new PKBM_BunsyonoSettei(
            pBunsyosyubetukbn,
            pAisyoumeikbn,
            pChannelcd,
            pOyadrtencd,
            pRenno
        );
    }

    @Transient
    @Override
    public PKBM_BunsyonoSettei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_BunsyonoSettei> getMetaClass() {
        return QBM_BunsyonoSettei.class;
    }

    @Id
    @Type(type="UserType_C_BunsyoSyubetuKbn")
    @Column(name=GenBM_BunsyonoSettei.BUNSYOSYUBETUKBN)
    public C_BunsyoSyubetuKbn getBunsyosyubetukbn() {
        return getPrimaryKey().getBunsyosyubetukbn();
    }

    public void setBunsyosyubetukbn(C_BunsyoSyubetuKbn pBunsyosyubetukbn) {
        getPrimaryKey().setBunsyosyubetukbn(pBunsyosyubetukbn);
    }

    @Id
    @Type(type="UserType_C_AisyoumeiKbn")
    @Column(name=GenBM_BunsyonoSettei.AISYOUMEIKBN)
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return getPrimaryKey().getAisyoumeikbn();
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        getPrimaryKey().setAisyoumeikbn(pAisyoumeikbn);
    }

    @Id
    @Type(type="UserType_C_Channelcd")
    @Column(name=GenBM_BunsyonoSettei.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return getPrimaryKey().getChannelcd();
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        getPrimaryKey().setChannelcd(pChannelcd);
    }

    @Id
    @Column(name=GenBM_BunsyonoSettei.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return getPrimaryKey().getOyadrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        getPrimaryKey().setOyadrtencd(pOyadrtencd);
    }

    @Id
    @Column(name=GenBM_BunsyonoSettei.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate tekiyouYmdFrom;

    @Type(type="BizDateType")
    @Column(name=GenBM_BunsyonoSettei.TEKIYOUYMDFROM)
    @ValidDate
    public BizDate getTekiyouYmdFrom() {
        return tekiyouYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyouYmdFrom(BizDate pTekiyouYmdFrom) {
        tekiyouYmdFrom = pTekiyouYmdFrom;
    }

    private BizDate tekiyouYmdTo;

    @Type(type="BizDateType")
    @Column(name=GenBM_BunsyonoSettei.TEKIYOUYMDTO)
    @ValidDate
    public BizDate getTekiyouYmdTo() {
        return tekiyouYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyouYmdTo(BizDate pTekiyouYmdTo) {
        tekiyouYmdTo = pTekiyouYmdTo;
    }

    private String bunsyono;

    @Column(name=GenBM_BunsyonoSettei.BUNSYONO)
    public String getBunsyono() {
        return bunsyono;
    }

    public void setBunsyono(String pBunsyono) {
        bunsyono = pBunsyono;
    }

    private String siorino;

    @Column(name=GenBM_BunsyonoSettei.SIORINO)
    public String getSiorino() {
        return siorino;
    }

    public void setSiorino(String pSiorino) {
        siorino = pSiorino;
    }
}