package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_DrtenMinyuKykNaiyou;
import yuyu.def.db.mapping.GenIT_DrtenMinyuKykNaiyou;
import yuyu.def.db.meta.GenQIT_DrtenMinyuKykNaiyou;
import yuyu.def.db.meta.QIT_DrtenMinyuKykNaiyou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 代理店未入契約明細内容テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_DrtenMinyuKykNaiyou}</td><td colspan="3">代理店未入契約明細内容テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriym syoriym}</td><td>処理年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>keiyakuymd</td><td>契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bosyuuym</td><td>募集年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>syuukeikbn</td><td>集計区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyukaisuu</td><td>未入回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hsys</td><td>保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syuuseis</td><td>修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hukkatutyuuikbn</td><td>復活注意区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mrarihyj</td><td>ＭＲ有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fstttkekykhyj</td><td>初回立替契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttkernzkkaisuu</td><td>立替計上連続回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>keizokutyuuihyj</td><td>継続注意表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhinbunruikbn</td><td>商品分類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnmkbn</td><td>商品名称区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyukigou</td><td>保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>hurihunokbn</td><td>振替不能理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HurihunoKbn C_HurihunoKbn}</td></tr>
 *  <tr><td>autocallkykhyj</td><td>オートコール対象契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuudairitenatkikeitaikbn</td><td>募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn C_BosyuuDairitenAtkiKeitaiKbn}</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitencd2</td><td>代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanrisosikicd1</td><td>代理店管理組織コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanrisosikicd2</td><td>代理店管理組織コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenchannelsyuruikbn1</td><td>代理店チャネル種類区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DrtenChannelSyurui C_DrtenChannelSyurui}</td></tr>
 *  <tr><td>drtenchannelsyuruikbn2</td><td>代理店チャネル種類区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DrtenChannelSyurui C_DrtenChannelSyurui}</td></tr>
 *  <tr><td>bosyuucd1</td><td>募集人コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd2</td><td>募集人コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuuningyouhaiymd1</td><td>募集人業廃年月日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bosyuuningyouhaiymd2</td><td>募集人業廃年月日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kydatkikbnkj</td><td>共同扱区分（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ikkatubaraikbn</td><td>一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IkkatubaraiKbn C_IkkatubaraiKbn}</td></tr>
 *  <tr><td>ikkatubaraikaisuu</td><td>一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IkkatubaraiKaisuuKbn C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>cifcd</td><td>ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yykknmnryymd</td><td>猶予期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyknm35keta</td><td>契約者名（３５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinkihontikucd</td><td>通信先基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjitsinkaiadr</td><td>漢字通信先下位住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai2tsintelno</td><td>第２通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nexthurikaeymd</td><td>次回振替日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>minyusyoriymd</td><td>未入処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>jkiannaikg</td><td>次回案内金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>misyuup</td><td>未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_DrtenMinyuKykNaiyou
 * @see     GenIT_DrtenMinyuKykNaiyou
 * @see     QIT_DrtenMinyuKykNaiyou
 * @see     GenQIT_DrtenMinyuKykNaiyou
 */
public class PKIT_DrtenMinyuKykNaiyou extends AbstractExDBPrimaryKey<IT_DrtenMinyuKykNaiyou, PKIT_DrtenMinyuKykNaiyou> {

    private static final long serialVersionUID = 1L;

    public PKIT_DrtenMinyuKykNaiyou() {
    }

    public PKIT_DrtenMinyuKykNaiyou(
        String pKbnkey,
        String pSyono,
        BizDateYM pSyoriym
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        syoriym = pSyoriym;
    }

    @Transient
    @Override
    public Class<IT_DrtenMinyuKykNaiyou> getEntityClass() {
        return IT_DrtenMinyuKykNaiyou.class;
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
    private BizDateYM syoriym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getSyoriym() {
        return syoriym;
    }

    public void setSyoriym(BizDateYM pSyoriym) {
        syoriym = pSyoriym;
    }

}