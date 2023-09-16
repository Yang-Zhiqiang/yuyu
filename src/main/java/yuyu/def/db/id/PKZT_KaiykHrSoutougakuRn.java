package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuRn;
import yuyu.def.db.mapping.GenZT_KaiykHrSoutougakuRn;
import yuyu.def.db.meta.GenQZT_KaiykHrSoutougakuRn;
import yuyu.def.db.meta.QZT_KaiykHrSoutougakuRn;

/**
 * 解約返戻金相当額Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KaiykHrSoutougakuRn}</td><td colspan="3">解約返戻金相当額Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobiv12</td><td>（連携用）予備項目Ｖ１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeisankijyunym</td><td>（連携用）計算基準年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakanrino</td><td>（連携用）データ管理番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyutkkbn</td><td>（連携用）主契約特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuurisyuruicd</td><td>（連携用）数理種類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyousegmentkbn</td><td>（連携用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyourgnbnskkbn</td><td>（連携用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnharaikatakbn</td><td>（連携用）払方区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanitijibaraikbn</td><td>（連携用）転換一時払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyuutohukahyouji</td><td>（連携用）中途付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin6</td><td>（連携用）数理用予備項目Ｎ６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv6x2</td><td>（連携用）予備項目Ｖ６＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasipmenkbn</td><td>（連携用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasikousinkbn</td><td>（連携用）外出更新区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasimanagehyouji</td><td>（連携用）外出満年令表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasiphkbnmnoshyouji</td><td>（連携用）外出Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknkuzusnzyrttekitkarihyj</td><td>（連携用）健康増進乗率適用特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi</td><td>（連携用）保険種類記号予備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakugatakbn</td><td>（連携用）特約型区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryouritukbn</td><td>（連携用）料率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhihokensyaagev2</td><td>（連携用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen</td><td>（連携用）契約者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkbthsyumnryuhyouji</td><td>（連携用）特別保障満了表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknshry</td><td>（連携用）年金支払期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjyoutai</td><td>（連携用）契約状態</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnharaizumientyoujiage</td><td>（連携用）払済延長時年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnentyoukikan</td><td>（連携用）延長期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteimpbairitu</td><td>（連携用）指定月Ｐ倍率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpwarimasisiteim1</td><td>（連携用）Ｐ割増指定月１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpwarimasisiteim2</td><td>（連携用）Ｐ割増指定月２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaisyuusiteiym</td><td>（連携用）最終指定年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseizonkyuuhukinshrmd</td><td>（連携用）生存給付支払月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeikanensuu</td><td>（連携用）経過年数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeikatukisuu</td><td>（連携用）経過月数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjikaipjyuutouym</td><td>（連携用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntnknhktgkujyarhyouji</td><td>（連携用）転換引継控除有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukbn</td><td>（連携用）特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakuno</td><td>（連携用）特約番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndi2hknkknikoujihisyaage</td><td>（連携用）第２保険期間移行時被者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrecordno</td><td>（連携用）レコード番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmfkuriagekurisagekbn</td><td>（連携用）ＭＦ繰上げ繰下げ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmfannaihuyouriyuukbn</td><td>（連携用）ＭＦ案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrizmjhknsyukigousdkbn</td><td>（連携用）払済時保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokenhoutekiyouhyouji</td><td>（連携用）保険法適用表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokubetuhosyoukikan</td><td>（連携用）特別保障期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsintokujyouhyouji</td><td>（連携用）新特条表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkjykbn</td><td>（連携用）特条区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryoumasihyouten</td><td>（連携用）料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrndai2tokujyoukbn</td><td>（連携用）第２特条区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2ryoumasihyouten</td><td>（連携用）第２料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnytirrthndsysnmnskaisuu</td><td>（連携用）予定利率変動終身見直回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkousinmanryouage</td><td>（連携用）更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin9</td><td>（連携用）数理用予備項目Ｎ９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkrsgjhknsyukigousdkbn</td><td>（連携用）繰下げ時保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknkuzusnzyrt</td><td>（連携用）健康増進乗率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzyrthntiyustatuskbn</td><td>（連携用）乗率判定用ステータス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv15</td><td>（連携用）予備項目Ｖ１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnerrtokuteikoumoku</td><td>（連携用）エラー特定項目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihons</td><td>（連携用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhenkougokihons</td><td>（連携用）変更後基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhenkougosibous</td><td>（連携用）変更後死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngyousekihyoujis</td><td>（連携用）業績表示Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeitenkankakaku</td><td>（連携用）合計転換価格</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnwnasigoukeitenkanteikis</td><td>（連携用）Ｗなし合計転換定期Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyakuhr</td><td>（連携用）解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnryumsbbnkaiyakuhr</td><td>（連携用）料増部分解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnraysystemhyj</td><td>（連携用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaikakbn</td><td>（連携用）外貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaserate</td><td>（連携用）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkawaseratetekiyouymd</td><td>（連携用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaisinyoteiriritu</td><td>（連携用）最新予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsrkaiyakusjkkktyouseirrt</td><td>（連携用）数理用解約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsrkyksjkkktyouseiriritu</td><td>（連携用）数理用契約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnmvakeisankijyunymd</td><td>（連携用）ＭＶＡ計算基準年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmvatyouseikou</td><td>（連携用）ＭＶＡ調整項</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkeiyakujiyoteiriritu</td><td>（連携用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsrdai1hknkkn</td><td>（連携用）数理用第１保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin8</td><td>（連携用）数理用予備項目Ｎ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin10x2</td><td>（連携用）数理用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11x5</td><td>（連携用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x6</td><td>（連携用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x7</td><td>（連携用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x8</td><td>（連携用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x9</td><td>（連携用）予備項目Ｎ１１＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntuukasyukbn</td><td>（連携用）通貨種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv11</td><td>（連携用）予備項目Ｖ１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KaiykHrSoutougakuRn
 * @see     GenZT_KaiykHrSoutougakuRn
 * @see     QZT_KaiykHrSoutougakuRn
 * @see     GenQZT_KaiykHrSoutougakuRn
 */
public class PKZT_KaiykHrSoutougakuRn extends AbstractExDBPrimaryKey<ZT_KaiykHrSoutougakuRn, PKZT_KaiykHrSoutougakuRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KaiykHrSoutougakuRn() {
    }

    public PKZT_KaiykHrSoutougakuRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_KaiykHrSoutougakuRn> getEntityClass() {
        return ZT_KaiykHrSoutougakuRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}