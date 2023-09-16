package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.SV_NkHit;
import yuyu.def.db.mapping.GenSV_NkHit;
import yuyu.def.db.meta.GenQSV_NkHit;
import yuyu.def.db.meta.QSV_NkHit;

/**
 * 年金配当所要額ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_NkHit}</td><td colspan="3">年金配当所要額ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sznjk</td><td>生存状況</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sznjk C_Sznjk}</td></tr>
 *  <tr><td>seisikakymd</td><td>生死確認日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nksysyno</td><td>年金証書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkkknsetymd</td><td>年金基金設定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkshrstartymd</td><td>年金支払開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkkknmanryouymd</td><td>年金期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bnshrkaisuu</td><td>分割支払回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Bnshrkaisuu C_Bnshrkaisuu}</td></tr>
 *  <tr><td>jinendobnshrkaisuu</td><td>次年度分割支払回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Bnshrkaisuu C_Bnshrkaisuu}</td></tr>
 *  <tr><td>nkukthou</td><td>年金受取方法</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nkukthou C_Nkukthou}</td></tr>
 *  <tr><td>nkshrhsijiyuu</td><td>年金支払発生事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nkshrhsijiyuu C_Nkshrhsijiyuu}</td></tr>
 *  <tr><td>nextnsymd</td><td>次回年金支払日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nextnkshrkjt</td><td>次回年金支払期日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nextshryoteisakuseiymd</td><td>次回支払予定作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nexthurikaeymd</td><td>次回振替日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkshrjk</td><td>年金支払状況</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nkshrjk C_Nkshrjk}</td></tr>
 *  <tr><td>nksyoumetucd</td><td>年金消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkSyoumetuCd C_NkSyoumetuCd}</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>iktumu</td><td>一括支払有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nksysyhkymd</td><td>年金証書発行日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nksysysaihkymd</td><td>年金証書再発行日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ssnannaisksiymd</td><td>最新案内作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>annaikbn</td><td>案内区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AnnaiKbn C_AnnaiKbn}</td></tr>
 *  <tr><td>oyadairitencd1</td><td>親代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd1</td><td>募集人コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenbuntanwariai1</td><td>代理店分担割合１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>oyadairitencd2</td><td>親代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitencd2</td><td>代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd2</td><td>募集人コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenbuntanwariai2</td><td>代理店分担割合２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drtenkanrisosikicd1</td><td>代理店管理組織コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanritodoufukencd</td><td>代理店管理都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cifcd</td><td>ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>motosyono</td><td>元証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>aisyoumeikbn</td><td>愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AisyoumeiKbn C_AisyoumeiKbn}</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hknhouskkbn</td><td>保険法施行区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknhouskKbn C_HknhouskKbn}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>yenshrtkumukbn</td><td>円支払特約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stdrsktky</td><td>指定代理請求特約</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keizknenkinuktsiteitk</td><td>継続年金受取人指定特約</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>teisyutkykbn</td><td>定額年金主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>nenkinkbn</td><td>年金区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinKbn C_NenkinKbn}</td></tr>
 *  <tr><td>teinksyu</td><td>定額年金年金種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teinksyuruiversion</td><td>定額年金年金種類バージョン</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinkigousedaikbn</td><td>年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinKigouSedaiKbn C_NenkinKigouSedaiKbn}</td></tr>
 *  <tr><td>teinkspan</td><td>定額年金年金期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teikihongk</td><td>定額年金基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teihitukeihiyen</td><td>定額年金必要経費（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teihitukeihigaika</td><td>定額年金必要経費（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teihyounkspan</td><td>定額年金評価年金期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teinkkikingk</td><td>定額年金年金基金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nkgnskbn</td><td>年金原資区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkGnsKbn C_NkGnsKbn}</td></tr>
 *  <tr><td>nenkinkaisigoyoteiriritukbn</td><td>年金開始後予定利率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinjimutesuuryoukbn</td><td>年金事務手数料区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinJimuTesuuryouKbn C_NenkinJimuTesuuryouKbn}</td></tr>
 *  <tr><td>kyktumitateriritu</td><td>契約時積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tumitateriritu</td><td>積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tumitatekijyunymd</td><td>積立利率基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tumitatekijyunnen</td><td>積立利率基準年齢</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tumitatekijyunkkn</td><td>積立利率基準期間</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>fstinymd</td><td>初回取込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkhaitoukinuketorihoukbn</td><td>年金配当金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkHaitoukinuketorihouKbn C_NkHaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>nenreicalckbn</td><td>年齢計算区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenreiCalcKbn C_NenreiCalcKbn}</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknadrkj</td><td>被保険者住所（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknsakuinmeino</td><td>被保険者索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_NkHit
 * @see     GenSV_NkHit
 * @see     QSV_NkHit
 * @see     GenQSV_NkHit
 */
public class PKSV_NkHit extends AbstractExDBPrimaryKey<SV_NkHit, PKSV_NkHit> {

    private static final long serialVersionUID = 1L;

    public PKSV_NkHit() {
    }

    public PKSV_NkHit(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

    @Transient
    @Override
    public Class<SV_NkHit> getEntityClass() {
        return SV_NkHit.class;
    }

    private Integer renno8keta;

    public Integer getRenno8keta() {
        return renno8keta;
    }

    public void setRenno8keta(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

}