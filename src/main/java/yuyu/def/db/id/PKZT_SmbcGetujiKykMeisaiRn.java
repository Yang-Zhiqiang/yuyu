package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.mapping.GenZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.meta.GenQZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiRn;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SmbcGetujiKykMeisaiRn}</td><td colspan="3">ＳＭＢＣ月次契約明細Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndatakijyunymd zrndatakijyunymd}</td><td>（連携用）データ基準年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndatakijyunym zrndatakijyunym}</td><td>（連携用）データ基準年月</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaidirtncd</td><td>（連携用）Ａ扱代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbatukaidirtncd</td><td>（連携用）Ｂ扱代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaibosyuunincd</td><td>（連携用）Ａ扱募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbatukaibosyuunincd</td><td>（連携用）Ｂ扱募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmdhnaisyoumeicd</td><td>（連携用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuukacdsmbcgetuji</td><td>（連携用）通貨コード（ＳＭＢＣ月次契約Ｆ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkhuhukbn</td><td>（連携用）払込方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmknsmbcgetuji</td><td>（連携用）契約者名（カナ）（ＳＭＢＣ月次契約Ｆ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkjsmbcgetuji</td><td>（連携用）契約者名（漢字）（ＳＭＢＣ月次契約Ｆ）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkjsmbcgetuji</td><td>（連携用）被保険者名（漢字）（ＳＭＢＣ月次契約Ｆ）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnitijibrp</td><td>（連携用）一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeip2</td><td>（連携用）合計保険料２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzenkizennoup</td><td>（連携用）全期前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntumitatekngk</td><td>（連携用）積立金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntargettktoutatubi</td><td>（連携用）ターゲット到達日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmokuhyouti</td><td>（連携用）目標値</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmokuhyoukngk</td><td>（連携用）目標金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaiyakuhr</td><td>（連携用）解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhrkpjyuutouym</td><td>（連携用）払込保険料充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihrpruikeigk</td><td>（連携用）既払保険料累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntousyokykjikawaserate</td><td>（連携用）当初契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmankiymd</td><td>（連携用）満期年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikbn</td><td>（連携用）一括払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikaisuu</td><td>（連携用）一括払回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv56</td><td>（連携用）予備項目Ｖ５６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngmeigyoubijikawaserate</td><td>（連携用）月末営業日時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyobiv16</td><td>（連携用）予備項目Ｖ１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsymtymd</td><td>（連携用）消滅年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngetumatuymdidouw</td><td>（連携用）月末日異動解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngetumatuymdsibous</td><td>（連携用）月末日死亡保険金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv53</td><td>（連携用）予備項目Ｖ５３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SmbcGetujiKykMeisaiRn
 * @see     GenZT_SmbcGetujiKykMeisaiRn
 * @see     QZT_SmbcGetujiKykMeisaiRn
 * @see     GenQZT_SmbcGetujiKykMeisaiRn
 */
public class PKZT_SmbcGetujiKykMeisaiRn extends AbstractExDBPrimaryKey<ZT_SmbcGetujiKykMeisaiRn, PKZT_SmbcGetujiKykMeisaiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SmbcGetujiKykMeisaiRn() {
    }

    public PKZT_SmbcGetujiKykMeisaiRn(
        String pZrndatakijyunymd,
        String pZrndatakijyunym,
        String pZrnsyono
    ) {
        zrndatakijyunymd = pZrndatakijyunymd;
        zrndatakijyunym = pZrndatakijyunym;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_SmbcGetujiKykMeisaiRn> getEntityClass() {
        return ZT_SmbcGetujiKykMeisaiRn.class;
    }

    private String zrndatakijyunymd;

    public String getZrndatakijyunymd() {
        return zrndatakijyunymd;
    }

    public void setZrndatakijyunymd(String pZrndatakijyunymd) {
        zrndatakijyunymd = pZrndatakijyunymd;
    }
    private String zrndatakijyunym;

    public String getZrndatakijyunym() {
        return zrndatakijyunym;
    }

    public void setZrndatakijyunym(String pZrndatakijyunym) {
        zrndatakijyunym = pZrndatakijyunym;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}