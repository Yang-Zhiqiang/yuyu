package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.mapping.GenAM_SyoruiZokusei;
import yuyu.def.db.meta.GenQAM_SyoruiZokusei;
import yuyu.def.db.meta.QAM_SyoruiZokusei;

/**
 * 書類属性マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_SyoruiZokusei}</td><td colspan="3">書類属性マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>syoruinm</td><td>書類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruinmryaku</td><td>書類名（略称）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyouhyouid</td><td>帳票フォームＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hozonKikan</td><td>保存期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nengetukbn</td><td>年月区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NengetuKbn C_NengetuKbn}</td></tr>
 *  <tr><td>angoukaKbn</td><td>暗号化区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YesNoKbn C_YesNoKbn}</td></tr>
 *  <tr><td>pdfHozonKbn</td><td>ＰＤＦ保存区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YesNoKbn C_YesNoKbn}</td></tr>
 *  <tr><td>zipHozonKbn</td><td>ＺＩＰ保存区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YesNoKbn C_YesNoKbn}</td></tr>
 *  <tr><td>pageCount</td><td>ページ数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kensakuKey1</td><td>検索キー１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kensakuKey2</td><td>検索キー２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kensakuKey3</td><td>検索キー３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kensakuKey4</td><td>検索キー４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kensakuKey5</td><td>検索キー５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_SyoruiZokusei
 * @see     GenAM_SyoruiZokusei
 * @see     QAM_SyoruiZokusei
 * @see     GenQAM_SyoruiZokusei
 */
public class PKAM_SyoruiZokusei extends AbstractExDBPrimaryKey<AM_SyoruiZokusei, PKAM_SyoruiZokusei> {

    private static final long serialVersionUID = 1L;

    public PKAM_SyoruiZokusei() {
    }

    public PKAM_SyoruiZokusei(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    @Transient
    @Override
    public Class<AM_SyoruiZokusei> getEntityClass() {
        return AM_SyoruiZokusei.class;
    }

    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

}