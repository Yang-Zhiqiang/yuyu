package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.IT_YuukouKakErrorList;
import yuyu.def.db.id.PKIT_YuukouKakErrorList;
import yuyu.def.db.meta.GenQIT_YuukouKakErrorList;
import yuyu.def.db.meta.QIT_YuukouKakErrorList;
import yuyu.def.db.type.UserType_C_Yuukoukakkekka;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効確認エラーリストテーブル テーブルのマッピング情報クラスで、 {@link IT_YuukouKakErrorList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YuukouKakErrorList}</td><td colspan="3">有効確認エラーリストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_YuukouKakErrorList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKIT_YuukouKakErrorList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">{@link PKIT_YuukouKakErrorList ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getCredityuukoukakym credityuukoukakym}</td><td>クレジットカード有効確認年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getCredityuukoukakkekka credityuukoukakkekka}</td><td>クレジットカード有効確認結果</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Yuukoukakkekka}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YuukouKakErrorList
 * @see     PKIT_YuukouKakErrorList
 * @see     QIT_YuukouKakErrorList
 * @see     GenQIT_YuukouKakErrorList
 */
@MappedSuperclass
@Table(name=GenIT_YuukouKakErrorList.TABLE_NAME)
@IdClass(value=PKIT_YuukouKakErrorList.class)
@TypeDefs({
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Yuukoukakkekka", typeClass=UserType_C_Yuukoukakkekka.class)
})
public abstract class GenIT_YuukouKakErrorList extends AbstractExDBEntity<IT_YuukouKakErrorList, PKIT_YuukouKakErrorList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_YuukouKakErrorList";
    public static final String SYONO                    = "syono";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String SYORIYM                  = "syoriym";
    public static final String CREDITYUUKOUKAKYM        = "credityuukoukakym";
    public static final String CREDITYUUKOUKAKKEKKA     = "credityuukoukakkekka";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_YuukouKakErrorList primaryKey;

    public GenIT_YuukouKakErrorList() {
        primaryKey = new PKIT_YuukouKakErrorList();
    }

    public GenIT_YuukouKakErrorList(
        String pSyono,
        String pCreditkessaiyouno,
        BizDateYM pSyoriym
    ) {
        primaryKey = new PKIT_YuukouKakErrorList(
            pSyono,
            pCreditkessaiyouno,
            pSyoriym
        );
    }

    @Transient
    @Override
    public PKIT_YuukouKakErrorList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_YuukouKakErrorList> getMetaClass() {
        return QIT_YuukouKakErrorList.class;
    }

    @Id
    @Column(name=GenIT_YuukouKakErrorList.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenIT_YuukouKakErrorList.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenIT_YuukouKakErrorList.SYORIYM)
    public BizDateYM getSyoriym() {
        return getPrimaryKey().getSyoriym();
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        getPrimaryKey().setSyoriym(pSyoriym);
    }

    private BizDateYM credityuukoukakym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_YuukouKakErrorList.CREDITYUUKOUKAKYM)
    public BizDateYM getCredityuukoukakym() {
        return credityuukoukakym;
    }

    public void setCredityuukoukakym(BizDateYM pCredityuukoukakym) {
        credityuukoukakym = pCredityuukoukakym;
    }

    private C_Yuukoukakkekka credityuukoukakkekka;

    @Type(type="UserType_C_Yuukoukakkekka")
    @Column(name=GenIT_YuukouKakErrorList.CREDITYUUKOUKAKKEKKA)
    public C_Yuukoukakkekka getCredityuukoukakkekka() {
        return credityuukoukakkekka;
    }

    public void setCredityuukoukakkekka(C_Yuukoukakkekka pCredityuukoukakkekka) {
        credityuukoukakkekka = pCredityuukoukakkekka;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_YuukouKakErrorList.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_YuukouKakErrorList.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_YuukouKakErrorList.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}