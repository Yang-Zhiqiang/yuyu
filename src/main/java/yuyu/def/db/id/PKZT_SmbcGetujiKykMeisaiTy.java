package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.mapping.GenZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.meta.GenQZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiTy;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SmbcGetujiKykMeisaiTy}</td><td colspan="3">ＳＭＢＣ月次契約明細Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydatakijyunymd ztydatakijyunymd}</td><td>（中継用）データ基準年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydatakijyunym ztydatakijyunym}</td><td>（中継用）データ基準年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaidirtncd</td><td>（中継用）Ａ扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybatukaidirtncd</td><td>（中継用）Ｂ扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaibosyuunincd</td><td>（中継用）Ａ扱募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybatukaibosyuunincd</td><td>（中継用）Ｂ扱募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymdhnaisyoumeicd</td><td>（中継用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuukacdsmbcgetuji</td><td>（中継用）通貨コード（ＳＭＢＣ月次契約Ｆ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkhuhukbn</td><td>（中継用）払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmknsmbcgetuji</td><td>（中継用）契約者名（カナ）（ＳＭＢＣ月次契約Ｆ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkjsmbcgetuji</td><td>（中継用）契約者名（漢字）（ＳＭＢＣ月次契約Ｆ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkjsmbcgetuji</td><td>（中継用）被保険者名（漢字）（ＳＭＢＣ月次契約Ｆ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibrp</td><td>（中継用）一時払保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeip2</td><td>（中継用）合計保険料２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzenkizennoup</td><td>（中継用）全期前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytumitatekngk</td><td>（中継用）積立金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytargettktoutatubi</td><td>（中継用）ターゲット到達日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymokuhyouti</td><td>（中継用）目標値</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymokuhyoukngk</td><td>（中継用）目標金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaiyakuhr</td><td>（中継用）解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhrkpjyuutouym</td><td>（中継用）払込保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihrpruikeigk</td><td>（中継用）既払保険料累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytousyokykjikawaserate</td><td>（中継用）当初契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymankiymd</td><td>（中継用）満期年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikbn</td><td>（中継用）一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikaisuu</td><td>（中継用）一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv56</td><td>（中継用）予備項目Ｖ５６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygmeigyoubijikawaserate</td><td>（中継用）月末営業日時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobiv16</td><td>（中継用）予備項目Ｖ１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysymtymd</td><td>（中継用）消滅年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygetumatuymdidouw</td><td>（中継用）月末日異動解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygetumatuymdsibous</td><td>（中継用）月末日死亡保険金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv53</td><td>（中継用）予備項目Ｖ５３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SmbcGetujiKykMeisaiTy
 * @see     GenZT_SmbcGetujiKykMeisaiTy
 * @see     QZT_SmbcGetujiKykMeisaiTy
 * @see     GenQZT_SmbcGetujiKykMeisaiTy
 */
public class PKZT_SmbcGetujiKykMeisaiTy extends AbstractExDBPrimaryKey<ZT_SmbcGetujiKykMeisaiTy, PKZT_SmbcGetujiKykMeisaiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SmbcGetujiKykMeisaiTy() {
    }

    public PKZT_SmbcGetujiKykMeisaiTy(
        String pZtydatakijyunymd,
        String pZtydatakijyunym,
        String pZtysyono
    ) {
        ztydatakijyunymd = pZtydatakijyunymd;
        ztydatakijyunym = pZtydatakijyunym;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_SmbcGetujiKykMeisaiTy> getEntityClass() {
        return ZT_SmbcGetujiKykMeisaiTy.class;
    }

    private String ztydatakijyunymd;

    public String getZtydatakijyunymd() {
        return ztydatakijyunymd;
    }

    public void setZtydatakijyunymd(String pZtydatakijyunymd) {
        ztydatakijyunymd = pZtydatakijyunymd;
    }
    private String ztydatakijyunym;

    public String getZtydatakijyunym() {
        return ztydatakijyunym;
    }

    public void setZtydatakijyunym(String pZtydatakijyunym) {
        ztydatakijyunym = pZtydatakijyunym;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}