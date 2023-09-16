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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.id.PKIT_KouzahuriMinyuTuuti;
import yuyu.def.db.meta.GenQIT_KouzahuriMinyuTuuti;
import yuyu.def.db.meta.QIT_KouzahuriMinyuTuuti;
import yuyu.def.db.type.UserType_C_AsTyouhyoukigouKbn;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Skszumiflg;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 口座振替未入通知テーブル テーブルのマッピング情報クラスで、 {@link IT_KouzahuriMinyuTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KouzahuriMinyuTuuti}</td><td colspan="3">口座振替未入通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KouzahuriMinyuTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KouzahuriMinyuTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_KouzahuriMinyuTuuti ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseyno toiawaseyno}</td><td>問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr1kj toiawaseadr1kj}</td><td>問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr2kj toiawaseadr2kj}</td><td>問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr3kj toiawaseadr3kj}</td><td>問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou1 toiawaseteluktkkanou1}</td><td>問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou2 toiawaseteluktkkanou2}</td><td>問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj2 toiawasesosikinmkj2}</td><td>第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno2 toiawasetelno2}</td><td>第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuutinm30keta tuutinm30keta}</td><td>通知名称（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg1 minyuttmsg1}</td><td>未入通知メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg2 minyuttmsg2}</td><td>未入通知メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg3 minyuttmsg3}</td><td>未入通知メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg4 minyuttmsg4}</td><td>未入通知メッセージ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg5 minyuttmsg5}</td><td>未入通知メッセージ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg6 minyuttmsg6}</td><td>未入通知メッセージ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg7 minyuttmsg7}</td><td>未入通知メッセージ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg8 minyuttmsg8}</td><td>未入通知メッセージ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg9 minyuttmsg9}</td><td>未入通知メッセージ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg10 minyuttmsg10}</td><td>未入通知メッセージ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg11 minyuttmsg11}</td><td>未入通知メッセージ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttmsg12 minyuttmsg12}</td><td>未入通知メッセージ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPannainm pannainm}</td><td>保険料案内名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkhou12keta hrkhou12keta}</td><td>払込方法（１２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNexthurikaenaiyou1 nexthurikaenaiyou1}</td><td>次回振替内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNexthurikaenaiyou2 nexthurikaenaiyou2}</td><td>次回振替内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNexthurikaenaiyou3 nexthurikaenaiyou3}</td><td>次回振替内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikokutukiyykkn1 saikokutukiyykkn1}</td><td>催告月猶予期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikokutukiyykkn2 saikokutukiyykkn2}</td><td>催告月猶予期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirmsg1 hrkmirmsg1}</td><td>振込依頼メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirmsg2 hrkmirmsg2}</td><td>振込依頼メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmirmsg3 hrkmirmsg3}</td><td>振込依頼メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenhurikaenaiyou1 zenhurikaenaiyou1}</td><td>前回振替内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenhurikaenaiyou2 zenhurikaenaiyou2}</td><td>前回振替内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenhurikaenaiyou3 zenhurikaenaiyou3}</td><td>前回振替内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZenhurikaenaiyou4 zenhurikaenaiyou4}</td><td>前回振替内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz37keta1 hurikaekz37keta1}</td><td>振替口座（３７桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz37keta2 hurikaekz37keta2}</td><td>振替口座（３７桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz37keta3 hurikaekz37keta3}</td><td>振替口座（３７桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz37keta4 hurikaekz37keta4}</td><td>振替口座（３７桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz37keta5 hurikaekz37keta5}</td><td>振替口座（３７桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurikaekz37keta6 hurikaekz37keta6}</td><td>振替口座（３７桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg1 minyuttaddmsg1}</td><td>未入通知追加メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg2 minyuttaddmsg2}</td><td>未入通知追加メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg3 minyuttaddmsg3}</td><td>未入通知追加メッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg4 minyuttaddmsg4}</td><td>未入通知追加メッセージ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg5 minyuttaddmsg5}</td><td>未入通知追加メッセージ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg6 minyuttaddmsg6}</td><td>未入通知追加メッセージ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg7 minyuttaddmsg7}</td><td>未入通知追加メッセージ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg8 minyuttaddmsg8}</td><td>未入通知追加メッセージ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg9 minyuttaddmsg9}</td><td>未入通知追加メッセージ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg10 minyuttaddmsg10}</td><td>未入通知追加メッセージ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg11 minyuttaddmsg11}</td><td>未入通知追加メッセージ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg12 minyuttaddmsg12}</td><td>未入通知追加メッセージ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg13 minyuttaddmsg13}</td><td>未入通知追加メッセージ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg14 minyuttaddmsg14}</td><td>未入通知追加メッセージ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg15 minyuttaddmsg15}</td><td>未入通知追加メッセージ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg16 minyuttaddmsg16}</td><td>未入通知追加メッセージ１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg17 minyuttaddmsg17}</td><td>未入通知追加メッセージ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg18 minyuttaddmsg18}</td><td>未入通知追加メッセージ１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg19 minyuttaddmsg19}</td><td>未入通知追加メッセージ１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg20 minyuttaddmsg20}</td><td>未入通知追加メッセージ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMinyuttaddmsg21 minyuttaddmsg21}</td><td>未入通知追加メッセージ２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuutisyuruicd tuutisyuruicd}</td><td>通知種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikokutuutizumiflg saikokutuutizumiflg}</td><td>催告通知作成済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Skszumiflg}</td></tr>
 *  <tr><td>{@link #getTyouhyoukigoukbn tyouhyoukigoukbn}</td><td>帳票記号区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AsTyouhyoukigouKbn}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KouzahuriMinyuTuuti
 * @see     PKIT_KouzahuriMinyuTuuti
 * @see     QIT_KouzahuriMinyuTuuti
 * @see     GenQIT_KouzahuriMinyuTuuti
 */
@MappedSuperclass
@Table(name=GenIT_KouzahuriMinyuTuuti.TABLE_NAME)
@IdClass(value=PKIT_KouzahuriMinyuTuuti.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AsTyouhyoukigouKbn", typeClass=UserType_C_AsTyouhyoukigouKbn.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_Skszumiflg", typeClass=UserType_C_Skszumiflg.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenIT_KouzahuriMinyuTuuti extends AbstractExDBEntity<IT_KouzahuriMinyuTuuti, PKIT_KouzahuriMinyuTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KouzahuriMinyuTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String SHSNMKJ                  = "shsnmkj";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASEYNO              = "toiawaseyno";
    public static final String TOIAWASEADR1KJ           = "toiawaseadr1kj";
    public static final String TOIAWASEADR2KJ           = "toiawaseadr2kj";
    public static final String TOIAWASEADR3KJ           = "toiawaseadr3kj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String TOIAWASETELUKTKKANOU1    = "toiawaseteluktkkanou1";
    public static final String TOIAWASETELUKTKKANOU2    = "toiawaseteluktkkanou2";
    public static final String TOIAWASESOSIKINMKJ2      = "toiawasesosikinmkj2";
    public static final String TOIAWASETELNO2           = "toiawasetelno2";
    public static final String TUUTINM30KETA            = "tuutinm30keta";
    public static final String MINYUTTMSG1              = "minyuttmsg1";
    public static final String MINYUTTMSG2              = "minyuttmsg2";
    public static final String MINYUTTMSG3              = "minyuttmsg3";
    public static final String MINYUTTMSG4              = "minyuttmsg4";
    public static final String MINYUTTMSG5              = "minyuttmsg5";
    public static final String MINYUTTMSG6              = "minyuttmsg6";
    public static final String MINYUTTMSG7              = "minyuttmsg7";
    public static final String MINYUTTMSG8              = "minyuttmsg8";
    public static final String MINYUTTMSG9              = "minyuttmsg9";
    public static final String MINYUTTMSG10             = "minyuttmsg10";
    public static final String MINYUTTMSG11             = "minyuttmsg11";
    public static final String MINYUTTMSG12             = "minyuttmsg12";
    public static final String PANNAINM                 = "pannainm";
    public static final String HRKHOU12KETA             = "hrkhou12keta";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String NEXTHURIKAENAIYOU1       = "nexthurikaenaiyou1";
    public static final String NEXTHURIKAENAIYOU2       = "nexthurikaenaiyou2";
    public static final String NEXTHURIKAENAIYOU3       = "nexthurikaenaiyou3";
    public static final String SAIKOKUTUKIYYKKN1        = "saikokutukiyykkn1";
    public static final String SAIKOKUTUKIYYKKN2        = "saikokutukiyykkn2";
    public static final String HRKMIRMSG1               = "hrkmirmsg1";
    public static final String HRKMIRMSG2               = "hrkmirmsg2";
    public static final String HRKMIRMSG3               = "hrkmirmsg3";
    public static final String ZENHURIKAENAIYOU1        = "zenhurikaenaiyou1";
    public static final String ZENHURIKAENAIYOU2        = "zenhurikaenaiyou2";
    public static final String ZENHURIKAENAIYOU3        = "zenhurikaenaiyou3";
    public static final String ZENHURIKAENAIYOU4        = "zenhurikaenaiyou4";
    public static final String HURIKAEKZ37KETA1         = "hurikaekz37keta1";
    public static final String HURIKAEKZ37KETA2         = "hurikaekz37keta2";
    public static final String HURIKAEKZ37KETA3         = "hurikaekz37keta3";
    public static final String HURIKAEKZ37KETA4         = "hurikaekz37keta4";
    public static final String HURIKAEKZ37KETA5         = "hurikaekz37keta5";
    public static final String HURIKAEKZ37KETA6         = "hurikaekz37keta6";
    public static final String MINYUTTADDMSG1           = "minyuttaddmsg1";
    public static final String MINYUTTADDMSG2           = "minyuttaddmsg2";
    public static final String MINYUTTADDMSG3           = "minyuttaddmsg3";
    public static final String MINYUTTADDMSG4           = "minyuttaddmsg4";
    public static final String MINYUTTADDMSG5           = "minyuttaddmsg5";
    public static final String MINYUTTADDMSG6           = "minyuttaddmsg6";
    public static final String MINYUTTADDMSG7           = "minyuttaddmsg7";
    public static final String MINYUTTADDMSG8           = "minyuttaddmsg8";
    public static final String MINYUTTADDMSG9           = "minyuttaddmsg9";
    public static final String MINYUTTADDMSG10          = "minyuttaddmsg10";
    public static final String MINYUTTADDMSG11          = "minyuttaddmsg11";
    public static final String MINYUTTADDMSG12          = "minyuttaddmsg12";
    public static final String MINYUTTADDMSG13          = "minyuttaddmsg13";
    public static final String MINYUTTADDMSG14          = "minyuttaddmsg14";
    public static final String MINYUTTADDMSG15          = "minyuttaddmsg15";
    public static final String MINYUTTADDMSG16          = "minyuttaddmsg16";
    public static final String MINYUTTADDMSG17          = "minyuttaddmsg17";
    public static final String MINYUTTADDMSG18          = "minyuttaddmsg18";
    public static final String MINYUTTADDMSG19          = "minyuttaddmsg19";
    public static final String MINYUTTADDMSG20          = "minyuttaddmsg20";
    public static final String MINYUTTADDMSG21          = "minyuttaddmsg21";
    public static final String TUUTISYURUICD            = "tuutisyuruicd";
    public static final String SAIKOKUTUUTIZUMIFLG      = "saikokutuutizumiflg";
    public static final String TYOUHYOUKIGOUKBN         = "tyouhyoukigoukbn";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KouzahuriMinyuTuuti primaryKey;

    public GenIT_KouzahuriMinyuTuuti() {
        primaryKey = new PKIT_KouzahuriMinyuTuuti();
    }

    public GenIT_KouzahuriMinyuTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_KouzahuriMinyuTuuti(
            pKbnkey,
            pSyono,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_KouzahuriMinyuTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KouzahuriMinyuTuuti> getMetaClass() {
        return QIT_KouzahuriMinyuTuuti.class;
    }

    @Id
    @Column(name=GenIT_KouzahuriMinyuTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KouzahuriMinyuTuuti.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenIT_KouzahuriMinyuTuuti.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_KouzahuriMinyuTuuti.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_KouzahuriMinyuTuuti.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String shskyno;

    @Column(name=GenIT_KouzahuriMinyuTuuti.SHSKYNO)
    @Length(length=7)
    @Digit
    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    private String shsadr1kj;

    @Column(name=GenIT_KouzahuriMinyuTuuti.SHSADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    private String shsadr2kj;

    @Column(name=GenIT_KouzahuriMinyuTuuti.SHSADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    private String shsadr3kj;

    @Column(name=GenIT_KouzahuriMinyuTuuti.SHSADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    private String shsnmkj;

    @Column(name=GenIT_KouzahuriMinyuTuuti.SHSNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsnmkj() {
        return shsnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj(String pShsnmkj) {
        shsnmkj = pShsnmkj;
    }

    private String toiawasesosikinmkj;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASESOSIKINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getToiawasesosikinmkj() {
        return toiawasesosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setToiawasesosikinmkj(String pToiawasesosikinmkj) {
        toiawasesosikinmkj = pToiawasesosikinmkj;
    }

    private String toiawaseyno;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASETELNO)
    @AlphaDigitOrExceptionCode(except=("-()"))
    @MaxLength(max=14)
    public String getToiawasetelno() {
        return toiawasetelno;
    }

    @DataConvert("toSingleByte")
    public void setToiawasetelno(String pToiawasetelno) {
        toiawasetelno = pToiawasetelno;
    }

    private String toiawaseteluktkkanou1;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private String toiawasesosikinmkj2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASESOSIKINMKJ2)
    public String getToiawasesosikinmkj2() {
        return toiawasesosikinmkj2;
    }

    public void setToiawasesosikinmkj2(String pToiawasesosikinmkj2) {
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
    }

    private String toiawasetelno2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TOIAWASETELNO2)
    public String getToiawasetelno2() {
        return toiawasetelno2;
    }

    public void setToiawasetelno2(String pToiawasetelno2) {
        toiawasetelno2 = pToiawasetelno2;
    }

    private String tuutinm30keta;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TUUTINM30KETA)
    public String getTuutinm30keta() {
        return tuutinm30keta;
    }

    public void setTuutinm30keta(String pTuutinm30keta) {
        tuutinm30keta = pTuutinm30keta;
    }

    private String minyuttmsg1;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG1)
    public String getMinyuttmsg1() {
        return minyuttmsg1;
    }

    public void setMinyuttmsg1(String pMinyuttmsg1) {
        minyuttmsg1 = pMinyuttmsg1;
    }

    private String minyuttmsg2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG2)
    public String getMinyuttmsg2() {
        return minyuttmsg2;
    }

    public void setMinyuttmsg2(String pMinyuttmsg2) {
        minyuttmsg2 = pMinyuttmsg2;
    }

    private String minyuttmsg3;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG3)
    public String getMinyuttmsg3() {
        return minyuttmsg3;
    }

    public void setMinyuttmsg3(String pMinyuttmsg3) {
        minyuttmsg3 = pMinyuttmsg3;
    }

    private String minyuttmsg4;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG4)
    public String getMinyuttmsg4() {
        return minyuttmsg4;
    }

    public void setMinyuttmsg4(String pMinyuttmsg4) {
        minyuttmsg4 = pMinyuttmsg4;
    }

    private String minyuttmsg5;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG5)
    public String getMinyuttmsg5() {
        return minyuttmsg5;
    }

    public void setMinyuttmsg5(String pMinyuttmsg5) {
        minyuttmsg5 = pMinyuttmsg5;
    }

    private String minyuttmsg6;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG6)
    public String getMinyuttmsg6() {
        return minyuttmsg6;
    }

    public void setMinyuttmsg6(String pMinyuttmsg6) {
        minyuttmsg6 = pMinyuttmsg6;
    }

    private String minyuttmsg7;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG7)
    public String getMinyuttmsg7() {
        return minyuttmsg7;
    }

    public void setMinyuttmsg7(String pMinyuttmsg7) {
        minyuttmsg7 = pMinyuttmsg7;
    }

    private String minyuttmsg8;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG8)
    public String getMinyuttmsg8() {
        return minyuttmsg8;
    }

    public void setMinyuttmsg8(String pMinyuttmsg8) {
        minyuttmsg8 = pMinyuttmsg8;
    }

    private String minyuttmsg9;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG9)
    public String getMinyuttmsg9() {
        return minyuttmsg9;
    }

    public void setMinyuttmsg9(String pMinyuttmsg9) {
        minyuttmsg9 = pMinyuttmsg9;
    }

    private String minyuttmsg10;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG10)
    public String getMinyuttmsg10() {
        return minyuttmsg10;
    }

    public void setMinyuttmsg10(String pMinyuttmsg10) {
        minyuttmsg10 = pMinyuttmsg10;
    }

    private String minyuttmsg11;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG11)
    public String getMinyuttmsg11() {
        return minyuttmsg11;
    }

    public void setMinyuttmsg11(String pMinyuttmsg11) {
        minyuttmsg11 = pMinyuttmsg11;
    }

    private String minyuttmsg12;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTMSG12)
    public String getMinyuttmsg12() {
        return minyuttmsg12;
    }

    public void setMinyuttmsg12(String pMinyuttmsg12) {
        minyuttmsg12 = pMinyuttmsg12;
    }

    private String pannainm;

    @Column(name=GenIT_KouzahuriMinyuTuuti.PANNAINM)
    public String getPannainm() {
        return pannainm;
    }

    public void setPannainm(String pPannainm) {
        pannainm = pPannainm;
    }

    private String hrkhou12keta;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HRKHOU12KETA)
    public String getHrkhou12keta() {
        return hrkhou12keta;
    }

    public void setHrkhou12keta(String pHrkhou12keta) {
        hrkhou12keta = pHrkhou12keta;
    }

    private String hhknnmkj;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private String nexthurikaenaiyou1;

    @Column(name=GenIT_KouzahuriMinyuTuuti.NEXTHURIKAENAIYOU1)
    public String getNexthurikaenaiyou1() {
        return nexthurikaenaiyou1;
    }

    public void setNexthurikaenaiyou1(String pNexthurikaenaiyou1) {
        nexthurikaenaiyou1 = pNexthurikaenaiyou1;
    }

    private String nexthurikaenaiyou2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.NEXTHURIKAENAIYOU2)
    public String getNexthurikaenaiyou2() {
        return nexthurikaenaiyou2;
    }

    public void setNexthurikaenaiyou2(String pNexthurikaenaiyou2) {
        nexthurikaenaiyou2 = pNexthurikaenaiyou2;
    }

    private String nexthurikaenaiyou3;

    @Column(name=GenIT_KouzahuriMinyuTuuti.NEXTHURIKAENAIYOU3)
    public String getNexthurikaenaiyou3() {
        return nexthurikaenaiyou3;
    }

    public void setNexthurikaenaiyou3(String pNexthurikaenaiyou3) {
        nexthurikaenaiyou3 = pNexthurikaenaiyou3;
    }

    private String saikokutukiyykkn1;

    @Column(name=GenIT_KouzahuriMinyuTuuti.SAIKOKUTUKIYYKKN1)
    public String getSaikokutukiyykkn1() {
        return saikokutukiyykkn1;
    }

    public void setSaikokutukiyykkn1(String pSaikokutukiyykkn1) {
        saikokutukiyykkn1 = pSaikokutukiyykkn1;
    }

    private String saikokutukiyykkn2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.SAIKOKUTUKIYYKKN2)
    public String getSaikokutukiyykkn2() {
        return saikokutukiyykkn2;
    }

    public void setSaikokutukiyykkn2(String pSaikokutukiyykkn2) {
        saikokutukiyykkn2 = pSaikokutukiyykkn2;
    }

    private String hrkmirmsg1;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HRKMIRMSG1)
    public String getHrkmirmsg1() {
        return hrkmirmsg1;
    }

    public void setHrkmirmsg1(String pHrkmirmsg1) {
        hrkmirmsg1 = pHrkmirmsg1;
    }

    private String hrkmirmsg2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HRKMIRMSG2)
    public String getHrkmirmsg2() {
        return hrkmirmsg2;
    }

    public void setHrkmirmsg2(String pHrkmirmsg2) {
        hrkmirmsg2 = pHrkmirmsg2;
    }

    private String hrkmirmsg3;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HRKMIRMSG3)
    public String getHrkmirmsg3() {
        return hrkmirmsg3;
    }

    public void setHrkmirmsg3(String pHrkmirmsg3) {
        hrkmirmsg3 = pHrkmirmsg3;
    }

    private String zenhurikaenaiyou1;

    @Column(name=GenIT_KouzahuriMinyuTuuti.ZENHURIKAENAIYOU1)
    public String getZenhurikaenaiyou1() {
        return zenhurikaenaiyou1;
    }

    public void setZenhurikaenaiyou1(String pZenhurikaenaiyou1) {
        zenhurikaenaiyou1 = pZenhurikaenaiyou1;
    }

    private String zenhurikaenaiyou2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.ZENHURIKAENAIYOU2)
    public String getZenhurikaenaiyou2() {
        return zenhurikaenaiyou2;
    }

    public void setZenhurikaenaiyou2(String pZenhurikaenaiyou2) {
        zenhurikaenaiyou2 = pZenhurikaenaiyou2;
    }

    private String zenhurikaenaiyou3;

    @Column(name=GenIT_KouzahuriMinyuTuuti.ZENHURIKAENAIYOU3)
    public String getZenhurikaenaiyou3() {
        return zenhurikaenaiyou3;
    }

    public void setZenhurikaenaiyou3(String pZenhurikaenaiyou3) {
        zenhurikaenaiyou3 = pZenhurikaenaiyou3;
    }

    private String zenhurikaenaiyou4;

    @Column(name=GenIT_KouzahuriMinyuTuuti.ZENHURIKAENAIYOU4)
    public String getZenhurikaenaiyou4() {
        return zenhurikaenaiyou4;
    }

    public void setZenhurikaenaiyou4(String pZenhurikaenaiyou4) {
        zenhurikaenaiyou4 = pZenhurikaenaiyou4;
    }

    private String hurikaekz37keta1;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HURIKAEKZ37KETA1)
    public String getHurikaekz37keta1() {
        return hurikaekz37keta1;
    }

    public void setHurikaekz37keta1(String pHurikaekz37keta1) {
        hurikaekz37keta1 = pHurikaekz37keta1;
    }

    private String hurikaekz37keta2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HURIKAEKZ37KETA2)
    public String getHurikaekz37keta2() {
        return hurikaekz37keta2;
    }

    public void setHurikaekz37keta2(String pHurikaekz37keta2) {
        hurikaekz37keta2 = pHurikaekz37keta2;
    }

    private String hurikaekz37keta3;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HURIKAEKZ37KETA3)
    public String getHurikaekz37keta3() {
        return hurikaekz37keta3;
    }

    public void setHurikaekz37keta3(String pHurikaekz37keta3) {
        hurikaekz37keta3 = pHurikaekz37keta3;
    }

    private String hurikaekz37keta4;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HURIKAEKZ37KETA4)
    public String getHurikaekz37keta4() {
        return hurikaekz37keta4;
    }

    public void setHurikaekz37keta4(String pHurikaekz37keta4) {
        hurikaekz37keta4 = pHurikaekz37keta4;
    }

    private String hurikaekz37keta5;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HURIKAEKZ37KETA5)
    public String getHurikaekz37keta5() {
        return hurikaekz37keta5;
    }

    public void setHurikaekz37keta5(String pHurikaekz37keta5) {
        hurikaekz37keta5 = pHurikaekz37keta5;
    }

    private String hurikaekz37keta6;

    @Column(name=GenIT_KouzahuriMinyuTuuti.HURIKAEKZ37KETA6)
    public String getHurikaekz37keta6() {
        return hurikaekz37keta6;
    }

    public void setHurikaekz37keta6(String pHurikaekz37keta6) {
        hurikaekz37keta6 = pHurikaekz37keta6;
    }

    private String minyuttaddmsg1;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG1)
    public String getMinyuttaddmsg1() {
        return minyuttaddmsg1;
    }

    public void setMinyuttaddmsg1(String pMinyuttaddmsg1) {
        minyuttaddmsg1 = pMinyuttaddmsg1;
    }

    private String minyuttaddmsg2;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG2)
    public String getMinyuttaddmsg2() {
        return minyuttaddmsg2;
    }

    public void setMinyuttaddmsg2(String pMinyuttaddmsg2) {
        minyuttaddmsg2 = pMinyuttaddmsg2;
    }

    private String minyuttaddmsg3;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG3)
    public String getMinyuttaddmsg3() {
        return minyuttaddmsg3;
    }

    public void setMinyuttaddmsg3(String pMinyuttaddmsg3) {
        minyuttaddmsg3 = pMinyuttaddmsg3;
    }

    private String minyuttaddmsg4;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG4)
    public String getMinyuttaddmsg4() {
        return minyuttaddmsg4;
    }

    public void setMinyuttaddmsg4(String pMinyuttaddmsg4) {
        minyuttaddmsg4 = pMinyuttaddmsg4;
    }

    private String minyuttaddmsg5;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG5)
    public String getMinyuttaddmsg5() {
        return minyuttaddmsg5;
    }

    public void setMinyuttaddmsg5(String pMinyuttaddmsg5) {
        minyuttaddmsg5 = pMinyuttaddmsg5;
    }

    private String minyuttaddmsg6;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG6)
    public String getMinyuttaddmsg6() {
        return minyuttaddmsg6;
    }

    public void setMinyuttaddmsg6(String pMinyuttaddmsg6) {
        minyuttaddmsg6 = pMinyuttaddmsg6;
    }

    private String minyuttaddmsg7;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG7)
    public String getMinyuttaddmsg7() {
        return minyuttaddmsg7;
    }

    public void setMinyuttaddmsg7(String pMinyuttaddmsg7) {
        minyuttaddmsg7 = pMinyuttaddmsg7;
    }

    private String minyuttaddmsg8;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG8)
    public String getMinyuttaddmsg8() {
        return minyuttaddmsg8;
    }

    public void setMinyuttaddmsg8(String pMinyuttaddmsg8) {
        minyuttaddmsg8 = pMinyuttaddmsg8;
    }

    private String minyuttaddmsg9;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG9)
    public String getMinyuttaddmsg9() {
        return minyuttaddmsg9;
    }

    public void setMinyuttaddmsg9(String pMinyuttaddmsg9) {
        minyuttaddmsg9 = pMinyuttaddmsg9;
    }

    private String minyuttaddmsg10;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG10)
    public String getMinyuttaddmsg10() {
        return minyuttaddmsg10;
    }

    public void setMinyuttaddmsg10(String pMinyuttaddmsg10) {
        minyuttaddmsg10 = pMinyuttaddmsg10;
    }

    private String minyuttaddmsg11;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG11)
    public String getMinyuttaddmsg11() {
        return minyuttaddmsg11;
    }

    public void setMinyuttaddmsg11(String pMinyuttaddmsg11) {
        minyuttaddmsg11 = pMinyuttaddmsg11;
    }

    private String minyuttaddmsg12;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG12)
    public String getMinyuttaddmsg12() {
        return minyuttaddmsg12;
    }

    public void setMinyuttaddmsg12(String pMinyuttaddmsg12) {
        minyuttaddmsg12 = pMinyuttaddmsg12;
    }

    private String minyuttaddmsg13;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG13)
    public String getMinyuttaddmsg13() {
        return minyuttaddmsg13;
    }

    public void setMinyuttaddmsg13(String pMinyuttaddmsg13) {
        minyuttaddmsg13 = pMinyuttaddmsg13;
    }

    private String minyuttaddmsg14;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG14)
    public String getMinyuttaddmsg14() {
        return minyuttaddmsg14;
    }

    public void setMinyuttaddmsg14(String pMinyuttaddmsg14) {
        minyuttaddmsg14 = pMinyuttaddmsg14;
    }

    private String minyuttaddmsg15;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG15)
    public String getMinyuttaddmsg15() {
        return minyuttaddmsg15;
    }

    public void setMinyuttaddmsg15(String pMinyuttaddmsg15) {
        minyuttaddmsg15 = pMinyuttaddmsg15;
    }

    private String minyuttaddmsg16;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG16)
    public String getMinyuttaddmsg16() {
        return minyuttaddmsg16;
    }

    public void setMinyuttaddmsg16(String pMinyuttaddmsg16) {
        minyuttaddmsg16 = pMinyuttaddmsg16;
    }

    private String minyuttaddmsg17;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG17)
    public String getMinyuttaddmsg17() {
        return minyuttaddmsg17;
    }

    public void setMinyuttaddmsg17(String pMinyuttaddmsg17) {
        minyuttaddmsg17 = pMinyuttaddmsg17;
    }

    private String minyuttaddmsg18;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG18)
    public String getMinyuttaddmsg18() {
        return minyuttaddmsg18;
    }

    public void setMinyuttaddmsg18(String pMinyuttaddmsg18) {
        minyuttaddmsg18 = pMinyuttaddmsg18;
    }

    private String minyuttaddmsg19;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG19)
    public String getMinyuttaddmsg19() {
        return minyuttaddmsg19;
    }

    public void setMinyuttaddmsg19(String pMinyuttaddmsg19) {
        minyuttaddmsg19 = pMinyuttaddmsg19;
    }

    private String minyuttaddmsg20;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG20)
    public String getMinyuttaddmsg20() {
        return minyuttaddmsg20;
    }

    public void setMinyuttaddmsg20(String pMinyuttaddmsg20) {
        minyuttaddmsg20 = pMinyuttaddmsg20;
    }

    private String minyuttaddmsg21;

    @Column(name=GenIT_KouzahuriMinyuTuuti.MINYUTTADDMSG21)
    public String getMinyuttaddmsg21() {
        return minyuttaddmsg21;
    }

    public void setMinyuttaddmsg21(String pMinyuttaddmsg21) {
        minyuttaddmsg21 = pMinyuttaddmsg21;
    }

    private String tuutisyuruicd;

    @Column(name=GenIT_KouzahuriMinyuTuuti.TUUTISYURUICD)
    public String getTuutisyuruicd() {
        return tuutisyuruicd;
    }

    public void setTuutisyuruicd(String pTuutisyuruicd) {
        tuutisyuruicd = pTuutisyuruicd;
    }

    private C_Skszumiflg saikokutuutizumiflg;

    @Type(type="UserType_C_Skszumiflg")
    @Column(name=GenIT_KouzahuriMinyuTuuti.SAIKOKUTUUTIZUMIFLG)
    public C_Skszumiflg getSaikokutuutizumiflg() {
        return saikokutuutizumiflg;
    }

    public void setSaikokutuutizumiflg(C_Skszumiflg pSaikokutuutizumiflg) {
        saikokutuutizumiflg = pSaikokutuutizumiflg;
    }

    private C_AsTyouhyoukigouKbn tyouhyoukigoukbn;

    @Type(type="UserType_C_AsTyouhyoukigouKbn")
    @Column(name=GenIT_KouzahuriMinyuTuuti.TYOUHYOUKIGOUKBN)
    public C_AsTyouhyoukigouKbn getTyouhyoukigoukbn() {
        return tyouhyoukigoukbn;
    }

    public void setTyouhyoukigoukbn(C_AsTyouhyoukigouKbn pTyouhyoukigoukbn) {
        tyouhyoukigoukbn = pTyouhyoukigoukbn;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_KouzahuriMinyuTuuti.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KouzahuriMinyuTuuti.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KouzahuriMinyuTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KouzahuriMinyuTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KouzahuriMinyuTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}