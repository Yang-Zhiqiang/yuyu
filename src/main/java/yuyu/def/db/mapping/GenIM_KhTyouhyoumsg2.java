package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.classification.C_KhTyouhyoumsgbunruiKbn3;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhTyouhyoumsg2;
import yuyu.def.db.id.PKIM_KhTyouhyoumsg2;
import yuyu.def.db.meta.GenQIM_KhTyouhyoumsg2;
import yuyu.def.db.meta.QIM_KhTyouhyoumsg2;
import yuyu.def.db.type.UserType_C_KhTyouhyoumsgbunruiKbn1;
import yuyu.def.db.type.UserType_C_KhTyouhyoumsgbunruiKbn2;
import yuyu.def.db.type.UserType_C_KhTyouhyoumsgbunruiKbn3;
import yuyu.def.db.type.UserType_C_KyksyaSibouUmuKbn;
import yuyu.def.db.type.UserType_C_Meigihnkjiyuu;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全帳票メッセージマスタ２ テーブルのマッピング情報クラスで、 {@link IM_KhTyouhyoumsg2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhTyouhyoumsg2}</td><td colspan="3">契約保全帳票メッセージマスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKIM_KhTyouhyoumsg2 ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getMeigihnkjiyuu meigihnkjiyuu}</td><td>名義変更事由</td><td align="center">{@link PKIM_KhTyouhyoumsg2 ○}</td><td align="center">V</td><td>{@link C_Meigihnkjiyuu}</td></tr>
 *  <tr><td>{@link #getKyksbumu kyksbumu}</td><td>契約者死亡有無</td><td align="center">{@link PKIM_KhTyouhyoumsg2 ○}</td><td align="center">V</td><td>{@link C_KyksyaSibouUmuKbn}</td></tr>
 *  <tr><td>{@link #getShrumu shrumu}</td><td>支払有無区分</td><td align="center">{@link PKIM_KhTyouhyoumsg2 ○}</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTuityouumu tuityouumu}</td><td>追徴有無区分</td><td align="center">{@link PKIM_KhTyouhyoumsg2 ○}</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKhtyouhyoumsgbunruikbn1 khtyouhyoumsgbunruikbn1}</td><td>契約保全帳票メッセージ分類区分１</td><td align="center">{@link PKIM_KhTyouhyoumsg2 ○}</td><td align="center">V</td><td>{@link C_KhTyouhyoumsgbunruiKbn1}</td></tr>
 *  <tr><td>{@link #getKhtyouhyoumsgbunruikbn2 khtyouhyoumsgbunruikbn2}</td><td>契約保全帳票メッセージ分類区分２</td><td align="center">{@link PKIM_KhTyouhyoumsg2 ○}</td><td align="center">V</td><td>{@link C_KhTyouhyoumsgbunruiKbn2}</td></tr>
 *  <tr><td>{@link #getKhtyouhyoumsgbunruikbn3 khtyouhyoumsgbunruikbn3}</td><td>契約保全帳票メッセージ分類区分３</td><td align="center">{@link PKIM_KhTyouhyoumsg2 ○}</td><td align="center">V</td><td>{@link C_KhTyouhyoumsgbunruiKbn3}</td></tr>
 *  <tr><td>{@link #getTyouhyoutitle tyouhyoutitle}</td><td>帳票タイトル</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSksnm sksnm}</td><td>請求書名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg1 rsouhuannaimsg1}</td><td>（帳票用）送付案内メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg2 rsouhuannaimsg2}</td><td>（帳票用）送付案内メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg3 rsouhuannaimsg3}</td><td>（帳票用）送付案内メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg4 rsouhuannaimsg4}</td><td>（帳票用）送付案内メッセージ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg5 rsouhuannaimsg5}</td><td>（帳票用）送付案内メッセージ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg6 rsouhuannaimsg6}</td><td>（帳票用）送付案内メッセージ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg7 rsouhuannaimsg7}</td><td>（帳票用）送付案内メッセージ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg8 rsouhuannaimsg8}</td><td>（帳票用）送付案内メッセージ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg9 rsouhuannaimsg9}</td><td>（帳票用）送付案内メッセージ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRsouhuannaimsg10 rsouhuannaimsg10}</td><td>（帳票用）送付案内メッセージ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg1 rannainaiyoumsg1}</td><td>（帳票用）案内内容メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg2 rannainaiyoumsg2}</td><td>（帳票用）案内内容メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg3 rannainaiyoumsg3}</td><td>（帳票用）案内内容メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg4 rannainaiyoumsg4}</td><td>（帳票用）案内内容メッセージ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg5 rannainaiyoumsg5}</td><td>（帳票用）案内内容メッセージ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg6 rannainaiyoumsg6}</td><td>（帳票用）案内内容メッセージ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg7 rannainaiyoumsg7}</td><td>（帳票用）案内内容メッセージ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg8 rannainaiyoumsg8}</td><td>（帳票用）案内内容メッセージ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg9 rannainaiyoumsg9}</td><td>（帳票用）案内内容メッセージ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg10 rannainaiyoumsg10}</td><td>（帳票用）案内内容メッセージ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg11 rannainaiyoumsg11}</td><td>（帳票用）案内内容メッセージ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg12 rannainaiyoumsg12}</td><td>（帳票用）案内内容メッセージ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg13 rannainaiyoumsg13}</td><td>（帳票用）案内内容メッセージ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg14 rannainaiyoumsg14}</td><td>（帳票用）案内内容メッセージ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg15 rannainaiyoumsg15}</td><td>（帳票用）案内内容メッセージ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg16 rannainaiyoumsg16}</td><td>（帳票用）案内内容メッセージ１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg17 rannainaiyoumsg17}</td><td>（帳票用）案内内容メッセージ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg18 rannainaiyoumsg18}</td><td>（帳票用）案内内容メッセージ１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg19 rannainaiyoumsg19}</td><td>（帳票用）案内内容メッセージ１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg20 rannainaiyoumsg20}</td><td>（帳票用）案内内容メッセージ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg21 rannainaiyoumsg21}</td><td>（帳票用）案内内容メッセージ２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg22 rannainaiyoumsg22}</td><td>（帳票用）案内内容メッセージ２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg23 rannainaiyoumsg23}</td><td>（帳票用）案内内容メッセージ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg24 rannainaiyoumsg24}</td><td>（帳票用）案内内容メッセージ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg25 rannainaiyoumsg25}</td><td>（帳票用）案内内容メッセージ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg26 rannainaiyoumsg26}</td><td>（帳票用）案内内容メッセージ２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg27 rannainaiyoumsg27}</td><td>（帳票用）案内内容メッセージ２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg28 rannainaiyoumsg28}</td><td>（帳票用）案内内容メッセージ２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg29 rannainaiyoumsg29}</td><td>（帳票用）案内内容メッセージ２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRannainaiyoumsg30 rannainaiyoumsg30}</td><td>（帳票用）案内内容メッセージ３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhTyouhyoumsg2
 * @see     PKIM_KhTyouhyoumsg2
 * @see     QIM_KhTyouhyoumsg2
 * @see     GenQIM_KhTyouhyoumsg2
 */
@MappedSuperclass
@Table(name=GenIM_KhTyouhyoumsg2.TABLE_NAME)
@IdClass(value=PKIM_KhTyouhyoumsg2.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KhTyouhyoumsgbunruiKbn1", typeClass=UserType_C_KhTyouhyoumsgbunruiKbn1.class),
    @TypeDef(name="UserType_C_KhTyouhyoumsgbunruiKbn2", typeClass=UserType_C_KhTyouhyoumsgbunruiKbn2.class),
    @TypeDef(name="UserType_C_KhTyouhyoumsgbunruiKbn3", typeClass=UserType_C_KhTyouhyoumsgbunruiKbn3.class),
    @TypeDef(name="UserType_C_KyksyaSibouUmuKbn", typeClass=UserType_C_KyksyaSibouUmuKbn.class),
    @TypeDef(name="UserType_C_Meigihnkjiyuu", typeClass=UserType_C_Meigihnkjiyuu.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIM_KhTyouhyoumsg2 extends AbstractExDBEntity<IM_KhTyouhyoumsg2, PKIM_KhTyouhyoumsg2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_KhTyouhyoumsg2";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String MEIGIHNKJIYUU            = "meigihnkjiyuu";
    public static final String KYKSBUMU                 = "kyksbumu";
    public static final String SHRUMU                   = "shrumu";
    public static final String TUITYOUUMU               = "tuityouumu";
    public static final String KHTYOUHYOUMSGBUNRUIKBN1  = "khtyouhyoumsgbunruikbn1";
    public static final String KHTYOUHYOUMSGBUNRUIKBN2  = "khtyouhyoumsgbunruikbn2";
    public static final String KHTYOUHYOUMSGBUNRUIKBN3  = "khtyouhyoumsgbunruikbn3";
    public static final String TYOUHYOUTITLE            = "tyouhyoutitle";
    public static final String SKSNM                    = "sksnm";
    public static final String RSOUHUANNAIMSG1          = "rsouhuannaimsg1";
    public static final String RSOUHUANNAIMSG2          = "rsouhuannaimsg2";
    public static final String RSOUHUANNAIMSG3          = "rsouhuannaimsg3";
    public static final String RSOUHUANNAIMSG4          = "rsouhuannaimsg4";
    public static final String RSOUHUANNAIMSG5          = "rsouhuannaimsg5";
    public static final String RSOUHUANNAIMSG6          = "rsouhuannaimsg6";
    public static final String RSOUHUANNAIMSG7          = "rsouhuannaimsg7";
    public static final String RSOUHUANNAIMSG8          = "rsouhuannaimsg8";
    public static final String RSOUHUANNAIMSG9          = "rsouhuannaimsg9";
    public static final String RSOUHUANNAIMSG10         = "rsouhuannaimsg10";
    public static final String RANNAINAIYOUMSG1         = "rannainaiyoumsg1";
    public static final String RANNAINAIYOUMSG2         = "rannainaiyoumsg2";
    public static final String RANNAINAIYOUMSG3         = "rannainaiyoumsg3";
    public static final String RANNAINAIYOUMSG4         = "rannainaiyoumsg4";
    public static final String RANNAINAIYOUMSG5         = "rannainaiyoumsg5";
    public static final String RANNAINAIYOUMSG6         = "rannainaiyoumsg6";
    public static final String RANNAINAIYOUMSG7         = "rannainaiyoumsg7";
    public static final String RANNAINAIYOUMSG8         = "rannainaiyoumsg8";
    public static final String RANNAINAIYOUMSG9         = "rannainaiyoumsg9";
    public static final String RANNAINAIYOUMSG10        = "rannainaiyoumsg10";
    public static final String RANNAINAIYOUMSG11        = "rannainaiyoumsg11";
    public static final String RANNAINAIYOUMSG12        = "rannainaiyoumsg12";
    public static final String RANNAINAIYOUMSG13        = "rannainaiyoumsg13";
    public static final String RANNAINAIYOUMSG14        = "rannainaiyoumsg14";
    public static final String RANNAINAIYOUMSG15        = "rannainaiyoumsg15";
    public static final String RANNAINAIYOUMSG16        = "rannainaiyoumsg16";
    public static final String RANNAINAIYOUMSG17        = "rannainaiyoumsg17";
    public static final String RANNAINAIYOUMSG18        = "rannainaiyoumsg18";
    public static final String RANNAINAIYOUMSG19        = "rannainaiyoumsg19";
    public static final String RANNAINAIYOUMSG20        = "rannainaiyoumsg20";
    public static final String RANNAINAIYOUMSG21        = "rannainaiyoumsg21";
    public static final String RANNAINAIYOUMSG22        = "rannainaiyoumsg22";
    public static final String RANNAINAIYOUMSG23        = "rannainaiyoumsg23";
    public static final String RANNAINAIYOUMSG24        = "rannainaiyoumsg24";
    public static final String RANNAINAIYOUMSG25        = "rannainaiyoumsg25";
    public static final String RANNAINAIYOUMSG26        = "rannainaiyoumsg26";
    public static final String RANNAINAIYOUMSG27        = "rannainaiyoumsg27";
    public static final String RANNAINAIYOUMSG28        = "rannainaiyoumsg28";
    public static final String RANNAINAIYOUMSG29        = "rannainaiyoumsg29";
    public static final String RANNAINAIYOUMSG30        = "rannainaiyoumsg30";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_KhTyouhyoumsg2 primaryKey;

    public GenIM_KhTyouhyoumsg2() {
        primaryKey = new PKIM_KhTyouhyoumsg2();
    }

    public GenIM_KhTyouhyoumsg2(
        C_SyoruiCdKbn pSyoruiCd,
        C_Meigihnkjiyuu pMeigihnkjiyuu,
        C_KyksyaSibouUmuKbn pKyksbumu,
        C_UmuKbn pShrumu,
        C_UmuKbn pTuityouumu,
        C_KhTyouhyoumsgbunruiKbn1 pKhtyouhyoumsgbunruikbn1,
        C_KhTyouhyoumsgbunruiKbn2 pKhtyouhyoumsgbunruikbn2,
        C_KhTyouhyoumsgbunruiKbn3 pKhtyouhyoumsgbunruikbn3
    ) {
        primaryKey = new PKIM_KhTyouhyoumsg2(
            pSyoruiCd,
            pMeigihnkjiyuu,
            pKyksbumu,
            pShrumu,
            pTuityouumu,
            pKhtyouhyoumsgbunruikbn1,
            pKhtyouhyoumsgbunruikbn2,
            pKhtyouhyoumsgbunruikbn3
        );
    }

    @Transient
    @Override
    public PKIM_KhTyouhyoumsg2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_KhTyouhyoumsg2> getMetaClass() {
        return QIM_KhTyouhyoumsg2.class;
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIM_KhTyouhyoumsg2.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    @Id
    @Type(type="UserType_C_Meigihnkjiyuu")
    @Column(name=GenIM_KhTyouhyoumsg2.MEIGIHNKJIYUU)
    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return getPrimaryKey().getMeigihnkjiyuu();
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu pMeigihnkjiyuu) {
        getPrimaryKey().setMeigihnkjiyuu(pMeigihnkjiyuu);
    }

    @Id
    @Type(type="UserType_C_KyksyaSibouUmuKbn")
    @Column(name=GenIM_KhTyouhyoumsg2.KYKSBUMU)
    public C_KyksyaSibouUmuKbn getKyksbumu() {
        return getPrimaryKey().getKyksbumu();
    }

    public void setKyksbumu(C_KyksyaSibouUmuKbn pKyksbumu) {
        getPrimaryKey().setKyksbumu(pKyksbumu);
    }

    @Id
    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIM_KhTyouhyoumsg2.SHRUMU)
    public C_UmuKbn getShrumu() {
        return getPrimaryKey().getShrumu();
    }

    public void setShrumu(C_UmuKbn pShrumu) {
        getPrimaryKey().setShrumu(pShrumu);
    }

    @Id
    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIM_KhTyouhyoumsg2.TUITYOUUMU)
    public C_UmuKbn getTuityouumu() {
        return getPrimaryKey().getTuityouumu();
    }

    public void setTuityouumu(C_UmuKbn pTuityouumu) {
        getPrimaryKey().setTuityouumu(pTuityouumu);
    }

    @Id
    @Type(type="UserType_C_KhTyouhyoumsgbunruiKbn1")
    @Column(name=GenIM_KhTyouhyoumsg2.KHTYOUHYOUMSGBUNRUIKBN1)
    public C_KhTyouhyoumsgbunruiKbn1 getKhtyouhyoumsgbunruikbn1() {
        return getPrimaryKey().getKhtyouhyoumsgbunruikbn1();
    }

    public void setKhtyouhyoumsgbunruikbn1(C_KhTyouhyoumsgbunruiKbn1 pKhtyouhyoumsgbunruikbn1) {
        getPrimaryKey().setKhtyouhyoumsgbunruikbn1(pKhtyouhyoumsgbunruikbn1);
    }

    @Id
    @Type(type="UserType_C_KhTyouhyoumsgbunruiKbn2")
    @Column(name=GenIM_KhTyouhyoumsg2.KHTYOUHYOUMSGBUNRUIKBN2)
    public C_KhTyouhyoumsgbunruiKbn2 getKhtyouhyoumsgbunruikbn2() {
        return getPrimaryKey().getKhtyouhyoumsgbunruikbn2();
    }

    public void setKhtyouhyoumsgbunruikbn2(C_KhTyouhyoumsgbunruiKbn2 pKhtyouhyoumsgbunruikbn2) {
        getPrimaryKey().setKhtyouhyoumsgbunruikbn2(pKhtyouhyoumsgbunruikbn2);
    }

    @Id
    @Type(type="UserType_C_KhTyouhyoumsgbunruiKbn3")
    @Column(name=GenIM_KhTyouhyoumsg2.KHTYOUHYOUMSGBUNRUIKBN3)
    public C_KhTyouhyoumsgbunruiKbn3 getKhtyouhyoumsgbunruikbn3() {
        return getPrimaryKey().getKhtyouhyoumsgbunruikbn3();
    }

    public void setKhtyouhyoumsgbunruikbn3(C_KhTyouhyoumsgbunruiKbn3 pKhtyouhyoumsgbunruikbn3) {
        getPrimaryKey().setKhtyouhyoumsgbunruikbn3(pKhtyouhyoumsgbunruikbn3);
    }

    private String tyouhyoutitle;

    @Column(name=GenIM_KhTyouhyoumsg2.TYOUHYOUTITLE)
    public String getTyouhyoutitle() {
        return tyouhyoutitle;
    }

    public void setTyouhyoutitle(String pTyouhyoutitle) {
        tyouhyoutitle = pTyouhyoutitle;
    }

    private String sksnm;

    @Column(name=GenIM_KhTyouhyoumsg2.SKSNM)
    public String getSksnm() {
        return sksnm;
    }

    public void setSksnm(String pSksnm) {
        sksnm = pSksnm;
    }

    private String rsouhuannaimsg1;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG1)
    public String getRsouhuannaimsg1() {
        return rsouhuannaimsg1;
    }

    public void setRsouhuannaimsg1(String pRsouhuannaimsg1) {
        rsouhuannaimsg1 = pRsouhuannaimsg1;
    }

    private String rsouhuannaimsg2;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG2)
    public String getRsouhuannaimsg2() {
        return rsouhuannaimsg2;
    }

    public void setRsouhuannaimsg2(String pRsouhuannaimsg2) {
        rsouhuannaimsg2 = pRsouhuannaimsg2;
    }

    private String rsouhuannaimsg3;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG3)
    public String getRsouhuannaimsg3() {
        return rsouhuannaimsg3;
    }

    public void setRsouhuannaimsg3(String pRsouhuannaimsg3) {
        rsouhuannaimsg3 = pRsouhuannaimsg3;
    }

    private String rsouhuannaimsg4;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG4)
    public String getRsouhuannaimsg4() {
        return rsouhuannaimsg4;
    }

    public void setRsouhuannaimsg4(String pRsouhuannaimsg4) {
        rsouhuannaimsg4 = pRsouhuannaimsg4;
    }

    private String rsouhuannaimsg5;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG5)
    public String getRsouhuannaimsg5() {
        return rsouhuannaimsg5;
    }

    public void setRsouhuannaimsg5(String pRsouhuannaimsg5) {
        rsouhuannaimsg5 = pRsouhuannaimsg5;
    }

    private String rsouhuannaimsg6;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG6)
    public String getRsouhuannaimsg6() {
        return rsouhuannaimsg6;
    }

    public void setRsouhuannaimsg6(String pRsouhuannaimsg6) {
        rsouhuannaimsg6 = pRsouhuannaimsg6;
    }

    private String rsouhuannaimsg7;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG7)
    public String getRsouhuannaimsg7() {
        return rsouhuannaimsg7;
    }

    public void setRsouhuannaimsg7(String pRsouhuannaimsg7) {
        rsouhuannaimsg7 = pRsouhuannaimsg7;
    }

    private String rsouhuannaimsg8;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG8)
    public String getRsouhuannaimsg8() {
        return rsouhuannaimsg8;
    }

    public void setRsouhuannaimsg8(String pRsouhuannaimsg8) {
        rsouhuannaimsg8 = pRsouhuannaimsg8;
    }

    private String rsouhuannaimsg9;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG9)
    public String getRsouhuannaimsg9() {
        return rsouhuannaimsg9;
    }

    public void setRsouhuannaimsg9(String pRsouhuannaimsg9) {
        rsouhuannaimsg9 = pRsouhuannaimsg9;
    }

    private String rsouhuannaimsg10;

    @Column(name=GenIM_KhTyouhyoumsg2.RSOUHUANNAIMSG10)
    public String getRsouhuannaimsg10() {
        return rsouhuannaimsg10;
    }

    public void setRsouhuannaimsg10(String pRsouhuannaimsg10) {
        rsouhuannaimsg10 = pRsouhuannaimsg10;
    }

    private String rannainaiyoumsg1;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG1)
    public String getRannainaiyoumsg1() {
        return rannainaiyoumsg1;
    }

    public void setRannainaiyoumsg1(String pRannainaiyoumsg1) {
        rannainaiyoumsg1 = pRannainaiyoumsg1;
    }

    private String rannainaiyoumsg2;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG2)
    public String getRannainaiyoumsg2() {
        return rannainaiyoumsg2;
    }

    public void setRannainaiyoumsg2(String pRannainaiyoumsg2) {
        rannainaiyoumsg2 = pRannainaiyoumsg2;
    }

    private String rannainaiyoumsg3;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG3)
    public String getRannainaiyoumsg3() {
        return rannainaiyoumsg3;
    }

    public void setRannainaiyoumsg3(String pRannainaiyoumsg3) {
        rannainaiyoumsg3 = pRannainaiyoumsg3;
    }

    private String rannainaiyoumsg4;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG4)
    public String getRannainaiyoumsg4() {
        return rannainaiyoumsg4;
    }

    public void setRannainaiyoumsg4(String pRannainaiyoumsg4) {
        rannainaiyoumsg4 = pRannainaiyoumsg4;
    }

    private String rannainaiyoumsg5;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG5)
    public String getRannainaiyoumsg5() {
        return rannainaiyoumsg5;
    }

    public void setRannainaiyoumsg5(String pRannainaiyoumsg5) {
        rannainaiyoumsg5 = pRannainaiyoumsg5;
    }

    private String rannainaiyoumsg6;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG6)
    public String getRannainaiyoumsg6() {
        return rannainaiyoumsg6;
    }

    public void setRannainaiyoumsg6(String pRannainaiyoumsg6) {
        rannainaiyoumsg6 = pRannainaiyoumsg6;
    }

    private String rannainaiyoumsg7;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG7)
    public String getRannainaiyoumsg7() {
        return rannainaiyoumsg7;
    }

    public void setRannainaiyoumsg7(String pRannainaiyoumsg7) {
        rannainaiyoumsg7 = pRannainaiyoumsg7;
    }

    private String rannainaiyoumsg8;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG8)
    public String getRannainaiyoumsg8() {
        return rannainaiyoumsg8;
    }

    public void setRannainaiyoumsg8(String pRannainaiyoumsg8) {
        rannainaiyoumsg8 = pRannainaiyoumsg8;
    }

    private String rannainaiyoumsg9;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG9)
    public String getRannainaiyoumsg9() {
        return rannainaiyoumsg9;
    }

    public void setRannainaiyoumsg9(String pRannainaiyoumsg9) {
        rannainaiyoumsg9 = pRannainaiyoumsg9;
    }

    private String rannainaiyoumsg10;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG10)
    public String getRannainaiyoumsg10() {
        return rannainaiyoumsg10;
    }

    public void setRannainaiyoumsg10(String pRannainaiyoumsg10) {
        rannainaiyoumsg10 = pRannainaiyoumsg10;
    }

    private String rannainaiyoumsg11;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG11)
    public String getRannainaiyoumsg11() {
        return rannainaiyoumsg11;
    }

    public void setRannainaiyoumsg11(String pRannainaiyoumsg11) {
        rannainaiyoumsg11 = pRannainaiyoumsg11;
    }

    private String rannainaiyoumsg12;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG12)
    public String getRannainaiyoumsg12() {
        return rannainaiyoumsg12;
    }

    public void setRannainaiyoumsg12(String pRannainaiyoumsg12) {
        rannainaiyoumsg12 = pRannainaiyoumsg12;
    }

    private String rannainaiyoumsg13;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG13)
    public String getRannainaiyoumsg13() {
        return rannainaiyoumsg13;
    }

    public void setRannainaiyoumsg13(String pRannainaiyoumsg13) {
        rannainaiyoumsg13 = pRannainaiyoumsg13;
    }

    private String rannainaiyoumsg14;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG14)
    public String getRannainaiyoumsg14() {
        return rannainaiyoumsg14;
    }

    public void setRannainaiyoumsg14(String pRannainaiyoumsg14) {
        rannainaiyoumsg14 = pRannainaiyoumsg14;
    }

    private String rannainaiyoumsg15;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG15)
    public String getRannainaiyoumsg15() {
        return rannainaiyoumsg15;
    }

    public void setRannainaiyoumsg15(String pRannainaiyoumsg15) {
        rannainaiyoumsg15 = pRannainaiyoumsg15;
    }

    private String rannainaiyoumsg16;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG16)
    public String getRannainaiyoumsg16() {
        return rannainaiyoumsg16;
    }

    public void setRannainaiyoumsg16(String pRannainaiyoumsg16) {
        rannainaiyoumsg16 = pRannainaiyoumsg16;
    }

    private String rannainaiyoumsg17;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG17)
    public String getRannainaiyoumsg17() {
        return rannainaiyoumsg17;
    }

    public void setRannainaiyoumsg17(String pRannainaiyoumsg17) {
        rannainaiyoumsg17 = pRannainaiyoumsg17;
    }

    private String rannainaiyoumsg18;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG18)
    public String getRannainaiyoumsg18() {
        return rannainaiyoumsg18;
    }

    public void setRannainaiyoumsg18(String pRannainaiyoumsg18) {
        rannainaiyoumsg18 = pRannainaiyoumsg18;
    }

    private String rannainaiyoumsg19;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG19)
    public String getRannainaiyoumsg19() {
        return rannainaiyoumsg19;
    }

    public void setRannainaiyoumsg19(String pRannainaiyoumsg19) {
        rannainaiyoumsg19 = pRannainaiyoumsg19;
    }

    private String rannainaiyoumsg20;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG20)
    public String getRannainaiyoumsg20() {
        return rannainaiyoumsg20;
    }

    public void setRannainaiyoumsg20(String pRannainaiyoumsg20) {
        rannainaiyoumsg20 = pRannainaiyoumsg20;
    }

    private String rannainaiyoumsg21;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG21)
    public String getRannainaiyoumsg21() {
        return rannainaiyoumsg21;
    }

    public void setRannainaiyoumsg21(String pRannainaiyoumsg21) {
        rannainaiyoumsg21 = pRannainaiyoumsg21;
    }

    private String rannainaiyoumsg22;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG22)
    public String getRannainaiyoumsg22() {
        return rannainaiyoumsg22;
    }

    public void setRannainaiyoumsg22(String pRannainaiyoumsg22) {
        rannainaiyoumsg22 = pRannainaiyoumsg22;
    }

    private String rannainaiyoumsg23;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG23)
    public String getRannainaiyoumsg23() {
        return rannainaiyoumsg23;
    }

    public void setRannainaiyoumsg23(String pRannainaiyoumsg23) {
        rannainaiyoumsg23 = pRannainaiyoumsg23;
    }

    private String rannainaiyoumsg24;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG24)
    public String getRannainaiyoumsg24() {
        return rannainaiyoumsg24;
    }

    public void setRannainaiyoumsg24(String pRannainaiyoumsg24) {
        rannainaiyoumsg24 = pRannainaiyoumsg24;
    }

    private String rannainaiyoumsg25;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG25)
    public String getRannainaiyoumsg25() {
        return rannainaiyoumsg25;
    }

    public void setRannainaiyoumsg25(String pRannainaiyoumsg25) {
        rannainaiyoumsg25 = pRannainaiyoumsg25;
    }

    private String rannainaiyoumsg26;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG26)
    public String getRannainaiyoumsg26() {
        return rannainaiyoumsg26;
    }

    public void setRannainaiyoumsg26(String pRannainaiyoumsg26) {
        rannainaiyoumsg26 = pRannainaiyoumsg26;
    }

    private String rannainaiyoumsg27;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG27)
    public String getRannainaiyoumsg27() {
        return rannainaiyoumsg27;
    }

    public void setRannainaiyoumsg27(String pRannainaiyoumsg27) {
        rannainaiyoumsg27 = pRannainaiyoumsg27;
    }

    private String rannainaiyoumsg28;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG28)
    public String getRannainaiyoumsg28() {
        return rannainaiyoumsg28;
    }

    public void setRannainaiyoumsg28(String pRannainaiyoumsg28) {
        rannainaiyoumsg28 = pRannainaiyoumsg28;
    }

    private String rannainaiyoumsg29;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG29)
    public String getRannainaiyoumsg29() {
        return rannainaiyoumsg29;
    }

    public void setRannainaiyoumsg29(String pRannainaiyoumsg29) {
        rannainaiyoumsg29 = pRannainaiyoumsg29;
    }

    private String rannainaiyoumsg30;

    @Column(name=GenIM_KhTyouhyoumsg2.RANNAINAIYOUMSG30)
    public String getRannainaiyoumsg30() {
        return rannainaiyoumsg30;
    }

    public void setRannainaiyoumsg30(String pRannainaiyoumsg30) {
        rannainaiyoumsg30 = pRannainaiyoumsg30;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_KhTyouhyoumsg2.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_KhTyouhyoumsg2.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_KhTyouhyoumsg2.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}