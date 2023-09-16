package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.db.mapping.GenIT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.db.meta.GenQIT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.db.meta.QIT_SeihowebMizuhoMinyuuDtl;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 生保Ｗｅｂ・みずほ用未入明細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SeihowebMizuhoMinyuuDtl}</td><td colspan="3">生保Ｗｅｂ・みずほ用未入明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>minyusyoriymd</td><td>未入処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bosyuuym</td><td>募集年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kydatkikbnkj</td><td>共同扱区分（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknm35keta</td><td>契約者名（３５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cifcd</td><td>ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pjytym</td><td>保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>atesakinm</td><td>宛先名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyujytymdyofuri</td><td>未入充当年月（預振）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyujytymdyofuriigi</td><td>未入充当年月（預振以外）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hassinka</td><td>発信課</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>telno</td><td>電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tntnm10keta</td><td>担当者名（１０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuukj</td><td>払込回数（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkeirokj</td><td>払込経路（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>knkimnyuuryu</td><td>今回未入理由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jikaiminyuuji</td><td>次回未入時</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tntusygyouhaiinfo</td><td>担当者業廃情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkeirobtjhmidasi</td><td>払込経路別情報見出し</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkeirobtjh</td><td>払込経路別情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyuruinm30keta</td><td>保険種類名（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanrisosikicd</td><td>代理店管理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dbskyoteiym</td><td>ＤＢ削除予定年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>keiyakuymd</td><td>契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai2tsintelno</td><td>第２通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hukkatukanoukknmnryymd</td><td>復活可能期間満了年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hjnkykhyj</td><td>法人契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykjyutikbn</td><td>契約状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinkihontikucd</td><td>通信先基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjitsinkaiadr</td><td>漢字通信先下位住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jkiannaikg</td><td>次回案内金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yykknmnryymd</td><td>猶予期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>skymd</td><td>失効年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jhurikstkkahikbn</td><td>自動振替貸付可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hukkatumoskahikbn</td><td>復活申込可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdkkigenymd</td><td>手続き期限年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>keikamon3keta</td><td>経過月数（３桁）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>misyuuhasseiym</td><td>未収発生年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>misyuujiyuu</td><td>未収事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nexthurikaeymd</td><td>次回振替日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ikkatubaraikbn</td><td>一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IkkatubaraiKbn C_IkkatubaraiKbn}</td></tr>
 *  <tr><td>ikkatubaraikaisuu</td><td>一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IkkatubaraiKaisuuKbn C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>bosyuudairitengyousyukbn</td><td>募集代理店業種区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DrtenChannelSyurui C_DrtenChannelSyurui}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SeihowebMizuhoMinyuuDtl
 * @see     GenIT_SeihowebMizuhoMinyuuDtl
 * @see     QIT_SeihowebMizuhoMinyuuDtl
 * @see     GenQIT_SeihowebMizuhoMinyuuDtl
 */
public class PKIT_SeihowebMizuhoMinyuuDtl extends AbstractExDBPrimaryKey<IT_SeihowebMizuhoMinyuuDtl, PKIT_SeihowebMizuhoMinyuuDtl> {

    private static final long serialVersionUID = 1L;

    public PKIT_SeihowebMizuhoMinyuuDtl() {
    }

    public PKIT_SeihowebMizuhoMinyuuDtl(
        String pKbnkey,
        String pSyono,
        String pDrtencd,
        String pBosyuucd,
        BizDateYM pSyoriym
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        drtencd = pDrtencd;
        bosyuucd = pBosyuucd;
        syoriym = pSyoriym;
    }

    @Transient
    @Override
    public Class<IT_SeihowebMizuhoMinyuuDtl> getEntityClass() {
        return IT_SeihowebMizuhoMinyuuDtl.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String drtencd;

    public String getDrtencd() {
        return drtencd;
    }

    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }
    private String bosyuucd;

    public String getBosyuucd() {
        return bosyuucd;
    }

    public void setBosyuucd(String pBosyuucd) {
        bosyuucd = pBosyuucd;
    }
    private BizDateYM syoriym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getSyoriym() {
        return syoriym;
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        syoriym = pSyoriym;
    }

}