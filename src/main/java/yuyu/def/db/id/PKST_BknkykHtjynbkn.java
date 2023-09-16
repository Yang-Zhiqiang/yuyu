package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.mapping.GenST_BknkykHtjynbkn;
import yuyu.def.db.meta.GenQST_BknkykHtjynbkn;
import yuyu.def.db.meta.QST_BknkykHtjynbkn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 備金契約配当準備金テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_BknkykHtjynbkn}</td><td colspan="3">備金契約配当準備金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKakutyoujobcd kakutyoujobcd}</td><td>拡張ジョブコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyukigou</td><td>保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haraikomikaisukbn</td><td>払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkeirokbn</td><td>払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>annaihuyouriyuukbn</td><td>案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikinkbn</td><td>備金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikinnendokbn</td><td>備金年度区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seisand</td><td>精算Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tumitaterisoku</td><td>積立利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syuruicd1</td><td>種類コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syuruicd3</td><td>種類コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSrkijyunym srkijyunym}</td><td>数理用基準年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeiriyousegmentkbn</td><td>区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeiriyourgnbnskkbn</td><td>区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syuruicd2</td><td>種類コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kariwariatedganrikin</td><td>仮割当Ｄ元利金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedrisoku</td><td>仮割当Ｄ利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukeiyakusyuruicd</td><td>主契約種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknendo</td><td>契約年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daihyouyoteiriritu</td><td>代表予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>haraikatakbn</td><td>払方区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yobiv32</td><td>予備項目Ｖ３２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_BknkykHtjynbkn
 * @see     GenST_BknkykHtjynbkn
 * @see     QST_BknkykHtjynbkn
 * @see     GenQST_BknkykHtjynbkn
 */
public class PKST_BknkykHtjynbkn extends AbstractExDBPrimaryKey<ST_BknkykHtjynbkn, PKST_BknkykHtjynbkn> {

    private static final long serialVersionUID = 1L;

    public PKST_BknkykHtjynbkn() {
    }

    public PKST_BknkykHtjynbkn(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pSrkijyunym
    ) {
        syoriYmd = pSyoriYmd;
        kakutyoujobcd = pKakutyoujobcd;
        syono = pSyono;
        srkijyunym = pSrkijyunym;
    }

    @Transient
    @Override
    public Class<ST_BknkykHtjynbkn> getEntityClass() {
        return ST_BknkykHtjynbkn.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String kakutyoujobcd;

    public String getKakutyoujobcd() {
        return kakutyoujobcd;
    }

    public void setKakutyoujobcd(String pKakutyoujobcd) {
        kakutyoujobcd = pKakutyoujobcd;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String srkijyunym;

    public String getSrkijyunym() {
        return srkijyunym;
    }

    public void setSrkijyunym(String pSrkijyunym) {
        srkijyunym = pSrkijyunym;
    }

}