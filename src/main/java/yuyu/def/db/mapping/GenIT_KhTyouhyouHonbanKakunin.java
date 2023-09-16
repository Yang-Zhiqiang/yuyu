package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KakuninjyoutaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.db.entity.IT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.id.PKIT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.meta.GenQIT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.meta.QIT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.type.UserType_C_KakuninjyoutaiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_TyouhyouBunruiKbn;

/**
 * 契約保全帳票本番確認テーブル テーブルのマッピング情報クラスで、 {@link IT_KhTyouhyouHonbanKakunin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhTyouhyouHonbanKakunin}</td><td colspan="3">契約保全帳票本番確認テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTyouhyoubunrui tyouhyoubunrui}</td><td>帳票分類</td><td align="center">{@link PKIT_KhTyouhyouHonbanKakunin ○}</td><td align="center">V</td><td>{@link C_TyouhyouBunruiKbn}</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKIT_KhTyouhyouHonbanKakunin ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getJyoukenbunrui1 jyoukenbunrui1}</td><td>条件分類１</td><td align="center">{@link PKIT_KhTyouhyouHonbanKakunin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyoukenbunrui2 jyoukenbunrui2}</td><td>条件分類２</td><td align="center">{@link PKIT_KhTyouhyouHonbanKakunin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJyoukenbunrui3 jyoukenbunrui3}</td><td>条件分類３</td><td align="center">{@link PKIT_KhTyouhyouHonbanKakunin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKakuninjyoutaikbn kakuninjyoutaikbn}</td><td>確認状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KakuninjyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getHonbankakuninstartymd honbankakuninstartymd}</td><td>本番確認開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getFirstkaisouymd firstkaisouymd}</td><td>初回回送日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHonbankakuninymd honbankakuninymd}</td><td>本番確認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhTyouhyouHonbanKakunin
 * @see     PKIT_KhTyouhyouHonbanKakunin
 * @see     QIT_KhTyouhyouHonbanKakunin
 * @see     GenQIT_KhTyouhyouHonbanKakunin
 */
@MappedSuperclass
@Table(name=GenIT_KhTyouhyouHonbanKakunin.TABLE_NAME)
@IdClass(value=PKIT_KhTyouhyouHonbanKakunin.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KakuninjyoutaiKbn", typeClass=UserType_C_KakuninjyoutaiKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_TyouhyouBunruiKbn", typeClass=UserType_C_TyouhyouBunruiKbn.class)
})
public abstract class GenIT_KhTyouhyouHonbanKakunin extends AbstractExDBEntity<IT_KhTyouhyouHonbanKakunin, PKIT_KhTyouhyouHonbanKakunin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhTyouhyouHonbanKakunin";
    public static final String TYOUHYOUBUNRUI           = "tyouhyoubunrui";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String JYOUKENBUNRUI1           = "jyoukenbunrui1";
    public static final String JYOUKENBUNRUI2           = "jyoukenbunrui2";
    public static final String JYOUKENBUNRUI3           = "jyoukenbunrui3";
    public static final String KAKUNINJYOUTAIKBN        = "kakuninjyoutaikbn";
    public static final String HONBANKAKUNINSTARTYMD    = "honbankakuninstartymd";
    public static final String FIRSTKAISOUYMD           = "firstkaisouymd";
    public static final String HONBANKAKUNINYMD         = "honbankakuninymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhTyouhyouHonbanKakunin primaryKey;

    public GenIT_KhTyouhyouHonbanKakunin() {
        primaryKey = new PKIT_KhTyouhyouHonbanKakunin();
    }

    public GenIT_KhTyouhyouHonbanKakunin(
        C_TyouhyouBunruiKbn pTyouhyoubunrui,
        C_SyoruiCdKbn pSyoruiCd,
        String pJyoukenbunrui1,
        String pJyoukenbunrui2,
        String pJyoukenbunrui3
    ) {
        primaryKey = new PKIT_KhTyouhyouHonbanKakunin(
            pTyouhyoubunrui,
            pSyoruiCd,
            pJyoukenbunrui1,
            pJyoukenbunrui2,
            pJyoukenbunrui3
        );
    }

    @Transient
    @Override
    public PKIT_KhTyouhyouHonbanKakunin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhTyouhyouHonbanKakunin> getMetaClass() {
        return QIT_KhTyouhyouHonbanKakunin.class;
    }

    @Id
    @Type(type="UserType_C_TyouhyouBunruiKbn")
    @Column(name=GenIT_KhTyouhyouHonbanKakunin.TYOUHYOUBUNRUI)
    public C_TyouhyouBunruiKbn getTyouhyoubunrui() {
        return getPrimaryKey().getTyouhyoubunrui();
    }

    public void setTyouhyoubunrui(C_TyouhyouBunruiKbn pTyouhyoubunrui) {
        getPrimaryKey().setTyouhyoubunrui(pTyouhyoubunrui);
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_KhTyouhyouHonbanKakunin.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    @Id
    @Column(name=GenIT_KhTyouhyouHonbanKakunin.JYOUKENBUNRUI1)
    public String getJyoukenbunrui1() {
        return getPrimaryKey().getJyoukenbunrui1();
    }

    public void setJyoukenbunrui1(String pJyoukenbunrui1) {
        getPrimaryKey().setJyoukenbunrui1(pJyoukenbunrui1);
    }

    @Id
    @Column(name=GenIT_KhTyouhyouHonbanKakunin.JYOUKENBUNRUI2)
    public String getJyoukenbunrui2() {
        return getPrimaryKey().getJyoukenbunrui2();
    }

    public void setJyoukenbunrui2(String pJyoukenbunrui2) {
        getPrimaryKey().setJyoukenbunrui2(pJyoukenbunrui2);
    }

    @Id
    @Column(name=GenIT_KhTyouhyouHonbanKakunin.JYOUKENBUNRUI3)
    public String getJyoukenbunrui3() {
        return getPrimaryKey().getJyoukenbunrui3();
    }

    public void setJyoukenbunrui3(String pJyoukenbunrui3) {
        getPrimaryKey().setJyoukenbunrui3(pJyoukenbunrui3);
    }

    private C_KakuninjyoutaiKbn kakuninjyoutaikbn;

    @Type(type="UserType_C_KakuninjyoutaiKbn")
    @Column(name=GenIT_KhTyouhyouHonbanKakunin.KAKUNINJYOUTAIKBN)
    public C_KakuninjyoutaiKbn getKakuninjyoutaikbn() {
        return kakuninjyoutaikbn;
    }

    public void setKakuninjyoutaikbn(C_KakuninjyoutaiKbn pKakuninjyoutaikbn) {
        kakuninjyoutaikbn = pKakuninjyoutaikbn;
    }

    private BizDate honbankakuninstartymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhTyouhyouHonbanKakunin.HONBANKAKUNINSTARTYMD)
    public BizDate getHonbankakuninstartymd() {
        return honbankakuninstartymd;
    }

    public void setHonbankakuninstartymd(BizDate pHonbankakuninstartymd) {
        honbankakuninstartymd = pHonbankakuninstartymd;
    }

    private BizDate firstkaisouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhTyouhyouHonbanKakunin.FIRSTKAISOUYMD)
    public BizDate getFirstkaisouymd() {
        return firstkaisouymd;
    }

    public void setFirstkaisouymd(BizDate pFirstkaisouymd) {
        firstkaisouymd = pFirstkaisouymd;
    }

    private BizDate honbankakuninymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhTyouhyouHonbanKakunin.HONBANKAKUNINYMD)
    public BizDate getHonbankakuninymd() {
        return honbankakuninymd;
    }

    public void setHonbankakuninymd(BizDate pHonbankakuninymd) {
        honbankakuninymd = pHonbankakuninymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhTyouhyouHonbanKakunin.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhTyouhyouHonbanKakunin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhTyouhyouHonbanKakunin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}