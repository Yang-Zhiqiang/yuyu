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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BoskyuusiKijyunymdKbn;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_BosyuuKyuusi;
import yuyu.def.db.id.PKBM_BosyuuKyuusi;
import yuyu.def.db.meta.GenQBM_BosyuuKyuusi;
import yuyu.def.db.meta.QBM_BosyuuKyuusi;
import yuyu.def.db.type.UserType_C_BoskyuusiKijyunymdKbn;
import yuyu.def.db.type.UserType_C_BoskyuusiRiyuuKbn;
import yuyu.def.db.type.UserType_C_HubisyubetuKbn;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_SysKbn;

/**
 * 募集休止マスタ テーブルのマッピング情報クラスで、 {@link BM_BosyuuKyuusi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_BosyuuKyuusi}</td><td colspan="3">募集休止マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSksyskbn sksyskbn}</td><td>新契約システム区分</td><td align="center">{@link PKBM_BosyuuKyuusi ○}</td><td align="center">V</td><td>{@link C_SysKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_BosyuuKyuusi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoteiriritutkybr1 yoteiriritutkybr1}</td><td>予定利率適用分類１</td><td align="center">{@link PKBM_BosyuuKyuusi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoteiriritutkybr2 yoteiriritutkybr2}</td><td>予定利率適用分類２</td><td align="center">{@link PKBM_BosyuuKyuusi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">{@link PKBM_BosyuuKyuusi ○}</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr><td>{@link #getHanteiyuusendo hanteiyuusendo}</td><td>判定優先度</td><td align="center">{@link PKBM_BosyuuKyuusi ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getBoskyuusikijyunymdkbn boskyuusikijyunymdkbn}</td><td>募集休止基準日区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BoskyuusiKijyunymdKbn}</td></tr>
 *  <tr><td>{@link #getKyuusiymdfrom kyuusiymdfrom}</td><td>休止年月日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyuusiymdto kyuusiymdto}</td><td>休止年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBoskyuusiriyuukbn boskyuusiriyuukbn}</td><td>募集休止理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BoskyuusiRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getHubisyubetukbn hubisyubetukbn}</td><td>不備種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HubisyubetuKbn}</td></tr>
 *  <tr><td>{@link #getTokuninkahikbn tokuninkahikbn}</td><td>特認可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getHubimsg hubimsg}</td><td>不備メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeihowebmessage1 seihowebmessage1}</td><td>生保Ｗｅｂメッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeihowebmessage2 seihowebmessage2}</td><td>生保Ｗｅｂメッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_BosyuuKyuusi
 * @see     PKBM_BosyuuKyuusi
 * @see     QBM_BosyuuKyuusi
 * @see     GenQBM_BosyuuKyuusi
 */
@MappedSuperclass
@Table(name=GenBM_BosyuuKyuusi.TABLE_NAME)
@IdClass(value=PKBM_BosyuuKyuusi.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BoskyuusiKijyunymdKbn", typeClass=UserType_C_BoskyuusiKijyunymdKbn.class),
    @TypeDef(name="UserType_C_BoskyuusiRiyuuKbn", typeClass=UserType_C_BoskyuusiRiyuuKbn.class),
    @TypeDef(name="UserType_C_HubisyubetuKbn", typeClass=UserType_C_HubisyubetuKbn.class),
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class),
    @TypeDef(name="UserType_C_SkeijimuKbn", typeClass=UserType_C_SkeijimuKbn.class),
    @TypeDef(name="UserType_C_SysKbn", typeClass=UserType_C_SysKbn.class)
})
public abstract class GenBM_BosyuuKyuusi extends AbstractExDBEntity<BM_BosyuuKyuusi, PKBM_BosyuuKyuusi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_BosyuuKyuusi";
    public static final String SKSYSKBN                 = "sksyskbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String YOTEIRIRITUTKYBR1        = "yoteiriritutkybr1";
    public static final String YOTEIRIRITUTKYBR2        = "yoteiriritutkybr2";
    public static final String SKEIJIMUKBN              = "skeijimukbn";
    public static final String HANTEIYUUSENDO           = "hanteiyuusendo";
    public static final String BOSKYUUSIKIJYUNYMDKBN    = "boskyuusikijyunymdkbn";
    public static final String KYUUSIYMDFROM            = "kyuusiymdfrom";
    public static final String KYUUSIYMDTO              = "kyuusiymdto";
    public static final String BOSKYUUSIRIYUUKBN        = "boskyuusiriyuukbn";
    public static final String HUBISYUBETUKBN           = "hubisyubetukbn";
    public static final String TOKUNINKAHIKBN           = "tokuninkahikbn";
    public static final String HUBIMSG                  = "hubimsg";
    public static final String SEIHOWEBMESSAGE1         = "seihowebmessage1";
    public static final String SEIHOWEBMESSAGE2         = "seihowebmessage2";

    private final PKBM_BosyuuKyuusi primaryKey;

    public GenBM_BosyuuKyuusi() {
        primaryKey = new PKBM_BosyuuKyuusi();
    }

    public GenBM_BosyuuKyuusi(
        C_SysKbn pSksyskbn,
        String pSyouhncd,
        String pYoteiriritutkybr1,
        String pYoteiriritutkybr2,
        C_SkeijimuKbn pSkeijimukbn,
        Integer pHanteiyuusendo
    ) {
        primaryKey = new PKBM_BosyuuKyuusi(
            pSksyskbn,
            pSyouhncd,
            pYoteiriritutkybr1,
            pYoteiriritutkybr2,
            pSkeijimukbn,
            pHanteiyuusendo
        );
    }

    @Transient
    @Override
    public PKBM_BosyuuKyuusi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_BosyuuKyuusi> getMetaClass() {
        return QBM_BosyuuKyuusi.class;
    }

    @Id
    @Type(type="UserType_C_SysKbn")
    @Column(name=GenBM_BosyuuKyuusi.SKSYSKBN)
    public C_SysKbn getSksyskbn() {
        return getPrimaryKey().getSksyskbn();
    }

    public void setSksyskbn(C_SysKbn pSksyskbn) {
        getPrimaryKey().setSksyskbn(pSksyskbn);
    }

    @Id
    @Column(name=GenBM_BosyuuKyuusi.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenBM_BosyuuKyuusi.YOTEIRIRITUTKYBR1)
    public String getYoteiriritutkybr1() {
        return getPrimaryKey().getYoteiriritutkybr1();
    }

    public void setYoteiriritutkybr1(String pYoteiriritutkybr1) {
        getPrimaryKey().setYoteiriritutkybr1(pYoteiriritutkybr1);
    }

    @Id
    @Column(name=GenBM_BosyuuKyuusi.YOTEIRIRITUTKYBR2)
    public String getYoteiriritutkybr2() {
        return getPrimaryKey().getYoteiriritutkybr2();
    }

    public void setYoteiriritutkybr2(String pYoteiriritutkybr2) {
        getPrimaryKey().setYoteiriritutkybr2(pYoteiriritutkybr2);
    }

    @Id
    @Type(type="UserType_C_SkeijimuKbn")
    @Column(name=GenBM_BosyuuKyuusi.SKEIJIMUKBN)
    public C_SkeijimuKbn getSkeijimukbn() {
        return getPrimaryKey().getSkeijimukbn();
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        getPrimaryKey().setSkeijimukbn(pSkeijimukbn);
    }

    @Id
    @Column(name=GenBM_BosyuuKyuusi.HANTEIYUUSENDO)
    @Range(min="0", max="99")
    public Integer getHanteiyuusendo() {
        return getPrimaryKey().getHanteiyuusendo();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHanteiyuusendo(Integer pHanteiyuusendo) {
        getPrimaryKey().setHanteiyuusendo(pHanteiyuusendo);
    }

    private C_BoskyuusiKijyunymdKbn boskyuusikijyunymdkbn;

    @Type(type="UserType_C_BoskyuusiKijyunymdKbn")
    @Column(name=GenBM_BosyuuKyuusi.BOSKYUUSIKIJYUNYMDKBN)
    public C_BoskyuusiKijyunymdKbn getBoskyuusikijyunymdkbn() {
        return boskyuusikijyunymdkbn;
    }

    public void setBoskyuusikijyunymdkbn(C_BoskyuusiKijyunymdKbn pBoskyuusikijyunymdkbn) {
        boskyuusikijyunymdkbn = pBoskyuusikijyunymdkbn;
    }

    private BizDate kyuusiymdfrom;

    @Type(type="BizDateType")
    @Column(name=GenBM_BosyuuKyuusi.KYUUSIYMDFROM)
    public BizDate getKyuusiymdfrom() {
        return kyuusiymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyuusiymdfrom(BizDate pKyuusiymdfrom) {
        kyuusiymdfrom = pKyuusiymdfrom;
    }

    private BizDate kyuusiymdto;

    @Type(type="BizDateType")
    @Column(name=GenBM_BosyuuKyuusi.KYUUSIYMDTO)
    public BizDate getKyuusiymdto() {
        return kyuusiymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyuusiymdto(BizDate pKyuusiymdto) {
        kyuusiymdto = pKyuusiymdto;
    }

    private C_BoskyuusiRiyuuKbn boskyuusiriyuukbn;

    @Type(type="UserType_C_BoskyuusiRiyuuKbn")
    @Column(name=GenBM_BosyuuKyuusi.BOSKYUUSIRIYUUKBN)
    public C_BoskyuusiRiyuuKbn getBoskyuusiriyuukbn() {
        return boskyuusiriyuukbn;
    }

    public void setBoskyuusiriyuukbn(C_BoskyuusiRiyuuKbn pBoskyuusiriyuukbn) {
        boskyuusiriyuukbn = pBoskyuusiriyuukbn;
    }

    private C_HubisyubetuKbn hubisyubetukbn;

    @Type(type="UserType_C_HubisyubetuKbn")
    @Column(name=GenBM_BosyuuKyuusi.HUBISYUBETUKBN)
    public C_HubisyubetuKbn getHubisyubetukbn() {
        return hubisyubetukbn;
    }

    public void setHubisyubetukbn(C_HubisyubetuKbn pHubisyubetukbn) {
        hubisyubetukbn = pHubisyubetukbn;
    }

    private C_KahiKbn tokuninkahikbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenBM_BosyuuKyuusi.TOKUNINKAHIKBN)
    public C_KahiKbn getTokuninkahikbn() {
        return tokuninkahikbn;
    }

    public void setTokuninkahikbn(C_KahiKbn pTokuninkahikbn) {
        tokuninkahikbn = pTokuninkahikbn;
    }

    private String hubimsg;

    @Column(name=GenBM_BosyuuKyuusi.HUBIMSG)
    public String getHubimsg() {
        return hubimsg;
    }

    public void setHubimsg(String pHubimsg) {
        hubimsg = pHubimsg;
    }

    private String seihowebmessage1;

    @Column(name=GenBM_BosyuuKyuusi.SEIHOWEBMESSAGE1)
    public String getSeihowebmessage1() {
        return seihowebmessage1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeihowebmessage1(String pSeihowebmessage1) {
        seihowebmessage1 = pSeihowebmessage1;
    }

    private String seihowebmessage2;

    @Column(name=GenBM_BosyuuKyuusi.SEIHOWEBMESSAGE2)
    public String getSeihowebmessage2() {
        return seihowebmessage2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeihowebmessage2(String pSeihowebmessage2) {
        seihowebmessage2 = pSeihowebmessage2;
    }
}