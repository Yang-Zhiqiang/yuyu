package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_MsgHikisuuNaiyouKbn;
import yuyu.def.classification.C_MsgSyubetu;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.db.id.PKJM_SkNaiyouChk;
import yuyu.def.db.meta.GenQJM_SkNaiyouChk;
import yuyu.def.db.meta.QJM_SkNaiyouChk;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_MsgHikisuuNaiyouKbn;
import yuyu.def.db.type.UserType_C_MsgSyubetu;
import yuyu.def.db.type.UserType_C_SKNaiyouChkKbn;
import yuyu.def.db.type.UserType_C_YobidasimotoTaskKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 請求内容チェック判定マスタ テーブルのマッピング情報クラスで、 {@link JM_SkNaiyouChk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SkNaiyouChk}</td><td colspan="3">請求内容チェック判定マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSknaiyouchkkbn sknaiyouchkkbn}</td><td>請求内容チェック区分</td><td align="center">{@link PKJM_SkNaiyouChk ○}</td><td align="center">V</td><td>{@link C_SKNaiyouChkKbn}</td></tr>
 *  <tr><td>{@link #getYobidasimototaskkbn yobidasimototaskkbn}</td><td>呼出元タスク区分</td><td align="center">{@link PKJM_SkNaiyouChk ○}</td><td align="center">V</td><td>{@link C_YobidasimotoTaskKbn}</td></tr>
 *  <tr><td>{@link #getMsgsyubetu msgsyubetu}</td><td>メッセージ種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MsgSyubetu}</td></tr>
 *  <tr><td>{@link #getSateikaisouyouhikbn sateikaisouyouhikbn}</td><td>査定回送要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getKeisankahikbn keisankahikbn}</td><td>計算可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getMessageId messageId}</td><td>メッセージＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsghikisuunaiyoukbn1 msghikisuunaiyoukbn1}</td><td>メッセージ引数内容区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getMsghikisuu1 msghikisuu1}</td><td>メッセージ引数１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsghikisuunaiyoukbn2 msghikisuunaiyoukbn2}</td><td>メッセージ引数内容区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getMsghikisuu2 msghikisuu2}</td><td>メッセージ引数２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsghikisuunaiyoukbn3 msghikisuunaiyoukbn3}</td><td>メッセージ引数内容区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getMsghikisuu3 msghikisuu3}</td><td>メッセージ引数３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsghikisuunaiyoukbn4 msghikisuunaiyoukbn4}</td><td>メッセージ引数内容区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getMsghikisuu4 msghikisuu4}</td><td>メッセージ引数４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMsghikisuunaiyoukbn5 msghikisuunaiyoukbn5}</td><td>メッセージ引数内容区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MsgHikisuuNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getMsghikisuu5 msghikisuu5}</td><td>メッセージ引数５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_SkNaiyouChk
 * @see     PKJM_SkNaiyouChk
 * @see     QJM_SkNaiyouChk
 * @see     GenQJM_SkNaiyouChk
 */
@MappedSuperclass
@Table(name=GenJM_SkNaiyouChk.TABLE_NAME)
@IdClass(value=PKJM_SkNaiyouChk.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class),
    @TypeDef(name="UserType_C_MsgHikisuuNaiyouKbn", typeClass=UserType_C_MsgHikisuuNaiyouKbn.class),
    @TypeDef(name="UserType_C_MsgSyubetu", typeClass=UserType_C_MsgSyubetu.class),
    @TypeDef(name="UserType_C_SKNaiyouChkKbn", typeClass=UserType_C_SKNaiyouChkKbn.class),
    @TypeDef(name="UserType_C_YobidasimotoTaskKbn", typeClass=UserType_C_YobidasimotoTaskKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenJM_SkNaiyouChk extends AbstractExDBEntity<JM_SkNaiyouChk, PKJM_SkNaiyouChk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_SkNaiyouChk";
    public static final String SKNAIYOUCHKKBN           = "sknaiyouchkkbn";
    public static final String YOBIDASIMOTOTASKKBN      = "yobidasimototaskkbn";
    public static final String MSGSYUBETU               = "msgsyubetu";
    public static final String SATEIKAISOUYOUHIKBN      = "sateikaisouyouhikbn";
    public static final String KEISANKAHIKBN            = "keisankahikbn";
    public static final String MESSAGEID                = "messageId";
    public static final String MSGHIKISUUNAIYOUKBN1     = "msghikisuunaiyoukbn1";
    public static final String MSGHIKISUU1              = "msghikisuu1";
    public static final String MSGHIKISUUNAIYOUKBN2     = "msghikisuunaiyoukbn2";
    public static final String MSGHIKISUU2              = "msghikisuu2";
    public static final String MSGHIKISUUNAIYOUKBN3     = "msghikisuunaiyoukbn3";
    public static final String MSGHIKISUU3              = "msghikisuu3";
    public static final String MSGHIKISUUNAIYOUKBN4     = "msghikisuunaiyoukbn4";
    public static final String MSGHIKISUU4              = "msghikisuu4";
    public static final String MSGHIKISUUNAIYOUKBN5     = "msghikisuunaiyoukbn5";
    public static final String MSGHIKISUU5              = "msghikisuu5";

    private final PKJM_SkNaiyouChk primaryKey;

    public GenJM_SkNaiyouChk() {
        primaryKey = new PKJM_SkNaiyouChk();
    }

    public GenJM_SkNaiyouChk(C_SKNaiyouChkKbn pSknaiyouchkkbn, C_YobidasimotoTaskKbn pYobidasimototaskkbn) {
        primaryKey = new PKJM_SkNaiyouChk(pSknaiyouchkkbn, pYobidasimototaskkbn);
    }

    @Transient
    @Override
    public PKJM_SkNaiyouChk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_SkNaiyouChk> getMetaClass() {
        return QJM_SkNaiyouChk.class;
    }

    @Id
    @Type(type="UserType_C_SKNaiyouChkKbn")
    @Column(name=GenJM_SkNaiyouChk.SKNAIYOUCHKKBN)
    public C_SKNaiyouChkKbn getSknaiyouchkkbn() {
        return getPrimaryKey().getSknaiyouchkkbn();
    }

    public void setSknaiyouchkkbn(C_SKNaiyouChkKbn pSknaiyouchkkbn) {
        getPrimaryKey().setSknaiyouchkkbn(pSknaiyouchkkbn);
    }

    @Id
    @Type(type="UserType_C_YobidasimotoTaskKbn")
    @Column(name=GenJM_SkNaiyouChk.YOBIDASIMOTOTASKKBN)
    public C_YobidasimotoTaskKbn getYobidasimototaskkbn() {
        return getPrimaryKey().getYobidasimototaskkbn();
    }

    public void setYobidasimototaskkbn(C_YobidasimotoTaskKbn pYobidasimototaskkbn) {
        getPrimaryKey().setYobidasimototaskkbn(pYobidasimototaskkbn);
    }

    private C_MsgSyubetu msgsyubetu;

    @Type(type="UserType_C_MsgSyubetu")
    @Column(name=GenJM_SkNaiyouChk.MSGSYUBETU)
    public C_MsgSyubetu getMsgsyubetu() {
        return msgsyubetu;
    }

    public void setMsgsyubetu(C_MsgSyubetu pMsgsyubetu) {
        msgsyubetu = pMsgsyubetu;
    }

    private C_YouhiKbn sateikaisouyouhikbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenJM_SkNaiyouChk.SATEIKAISOUYOUHIKBN)
    public C_YouhiKbn getSateikaisouyouhikbn() {
        return sateikaisouyouhikbn;
    }

    public void setSateikaisouyouhikbn(C_YouhiKbn pSateikaisouyouhikbn) {
        sateikaisouyouhikbn = pSateikaisouyouhikbn;
    }

    private C_KahiKbn keisankahikbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenJM_SkNaiyouChk.KEISANKAHIKBN)
    public C_KahiKbn getKeisankahikbn() {
        return keisankahikbn;
    }

    public void setKeisankahikbn(C_KahiKbn pKeisankahikbn) {
        keisankahikbn = pKeisankahikbn;
    }

    private String messageId;

    @Column(name=GenJM_SkNaiyouChk.MESSAGEID)
    public String getMessageId() {
        return messageId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMessageId(String pMessageId) {
        messageId = pMessageId;
    }

    private C_MsgHikisuuNaiyouKbn msghikisuunaiyoukbn1;

    @Type(type="UserType_C_MsgHikisuuNaiyouKbn")
    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUUNAIYOUKBN1)
    public C_MsgHikisuuNaiyouKbn getMsghikisuunaiyoukbn1() {
        return msghikisuunaiyoukbn1;
    }

    public void setMsghikisuunaiyoukbn1(C_MsgHikisuuNaiyouKbn pMsghikisuunaiyoukbn1) {
        msghikisuunaiyoukbn1 = pMsghikisuunaiyoukbn1;
    }

    private String msghikisuu1;

    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUU1)
    public String getMsghikisuu1() {
        return msghikisuu1;
    }

    public void setMsghikisuu1(String pMsghikisuu1) {
        msghikisuu1 = pMsghikisuu1;
    }

    private C_MsgHikisuuNaiyouKbn msghikisuunaiyoukbn2;

    @Type(type="UserType_C_MsgHikisuuNaiyouKbn")
    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUUNAIYOUKBN2)
    public C_MsgHikisuuNaiyouKbn getMsghikisuunaiyoukbn2() {
        return msghikisuunaiyoukbn2;
    }

    public void setMsghikisuunaiyoukbn2(C_MsgHikisuuNaiyouKbn pMsghikisuunaiyoukbn2) {
        msghikisuunaiyoukbn2 = pMsghikisuunaiyoukbn2;
    }

    private String msghikisuu2;

    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUU2)
    public String getMsghikisuu2() {
        return msghikisuu2;
    }

    public void setMsghikisuu2(String pMsghikisuu2) {
        msghikisuu2 = pMsghikisuu2;
    }

    private C_MsgHikisuuNaiyouKbn msghikisuunaiyoukbn3;

    @Type(type="UserType_C_MsgHikisuuNaiyouKbn")
    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUUNAIYOUKBN3)
    public C_MsgHikisuuNaiyouKbn getMsghikisuunaiyoukbn3() {
        return msghikisuunaiyoukbn3;
    }

    public void setMsghikisuunaiyoukbn3(C_MsgHikisuuNaiyouKbn pMsghikisuunaiyoukbn3) {
        msghikisuunaiyoukbn3 = pMsghikisuunaiyoukbn3;
    }

    private String msghikisuu3;

    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUU3)
    public String getMsghikisuu3() {
        return msghikisuu3;
    }

    public void setMsghikisuu3(String pMsghikisuu3) {
        msghikisuu3 = pMsghikisuu3;
    }

    private C_MsgHikisuuNaiyouKbn msghikisuunaiyoukbn4;

    @Type(type="UserType_C_MsgHikisuuNaiyouKbn")
    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUUNAIYOUKBN4)
    public C_MsgHikisuuNaiyouKbn getMsghikisuunaiyoukbn4() {
        return msghikisuunaiyoukbn4;
    }

    public void setMsghikisuunaiyoukbn4(C_MsgHikisuuNaiyouKbn pMsghikisuunaiyoukbn4) {
        msghikisuunaiyoukbn4 = pMsghikisuunaiyoukbn4;
    }

    private String msghikisuu4;

    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUU4)
    public String getMsghikisuu4() {
        return msghikisuu4;
    }

    public void setMsghikisuu4(String pMsghikisuu4) {
        msghikisuu4 = pMsghikisuu4;
    }

    private C_MsgHikisuuNaiyouKbn msghikisuunaiyoukbn5;

    @Type(type="UserType_C_MsgHikisuuNaiyouKbn")
    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUUNAIYOUKBN5)
    public C_MsgHikisuuNaiyouKbn getMsghikisuunaiyoukbn5() {
        return msghikisuunaiyoukbn5;
    }

    public void setMsghikisuunaiyoukbn5(C_MsgHikisuuNaiyouKbn pMsghikisuunaiyoukbn5) {
        msghikisuunaiyoukbn5 = pMsghikisuunaiyoukbn5;
    }

    private String msghikisuu5;

    @Column(name=GenJM_SkNaiyouChk.MSGHIKISUU5)
    public String getMsghikisuu5() {
        return msghikisuu5;
    }

    public void setMsghikisuu5(String pMsghikisuu5) {
        msghikisuu5 = pMsghikisuu5;
    }
}