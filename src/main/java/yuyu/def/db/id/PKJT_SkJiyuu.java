package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.mapping.GenJT_SkJiyuu;
import yuyu.def.db.meta.GenQJT_SkJiyuu;
import yuyu.def.db.meta.QJT_SkJiyuu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求事由テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkJiyuu}</td><td colspan="3">請求事由テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>geninkbn</td><td>原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GeninKbn C_GeninKbn}</td></tr>
 *  <tr><td>jikosyosinymd</td><td>事故（初診）日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoubyouhsymd</td><td>傷病発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>saigaigeninkbn</td><td>災害原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SaigaiGeninKbn C_SaigaiGeninKbn}</td></tr>
 *  <tr><td>gansindankakuteiymd</td><td>がん診断確定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuuinjyoukyou</td><td>入院状況</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyuuinJyoukyou C_NyuuinJyoukyou}</td></tr>
 *  <tr><td>syuyouzaisiyouyoteiym</td><td>腫瘍剤使用予定年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kenpotaisyoukbn</td><td>健保対象区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KenpoTaisyouKbn C_KenpoTaisyouKbn}</td></tr>
 *  <tr><td>knptsgairytikenkbn</td><td>健保対象外理由（治験）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KnptsgtknKbn C_KnptsgtknKbn}</td></tr>
 *  <tr><td>knptsgairysensinkbn</td><td>健保対象外理由（先進医療）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KnptsgsnsnKbn C_KnptsgsnsnKbn}</td></tr>
 *  <tr><td>knptsgairykknaimsynnyakukbn</td><td>健保対象外理由（国内未承認薬）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KnptsgknmsnyKbn C_KnptsgknmsnyKbn}</td></tr>
 *  <tr><td>knptsgairykyyhkkyhmsynnkbn</td><td>健保対象外理由（効果用法未承認）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KnptsgkkmsnKbn C_KnptsgkkmsnKbn}</td></tr>
 *  <tr><td>knptsgairysonotakbn</td><td>健保対象外理由（その他）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KnptsgetcKbn C_KnptsgetcKbn}</td></tr>
 *  <tr><td>knptsgairysonotanaiyou</td><td>健保対象外理由（その他内容）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sibouymd</td><td>死亡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>siboubasyokbn</td><td>死亡場所区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SibouBasyoKbn C_SibouBasyoKbn}</td></tr>
 *  <tr><td>siboubasyo</td><td>死亡場所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syougaikoteiymd</td><td>障害固定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>pmenkbn</td><td>Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PmenKbn C_PmenKbn}</td></tr>
 *  <tr><td>pmenkoteiymd</td><td>Ｐ免固定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lnseikyuukbn</td><td>ＬＮ請求区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LnSeikyuuKbn C_LnSeikyuuKbn}</td></tr>
 *  <tr><td>lnsiteihokenkngk</td><td>ＬＮ指定保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkJiyuu
 * @see     GenJT_SkJiyuu
 * @see     QJT_SkJiyuu
 * @see     GenQJT_SkJiyuu
 */
public class PKJT_SkJiyuu extends AbstractExDBPrimaryKey<JT_SkJiyuu, PKJT_SkJiyuu> {

    private static final long serialVersionUID = 1L;

    public PKJT_SkJiyuu() {
    }

    public PKJT_SkJiyuu(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
        uketukeno = pUketukeno;
    }

    @Transient
    @Override
    public Class<JT_SkJiyuu> getEntityClass() {
        return JT_SkJiyuu.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer seikyuurirekino;

    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }
    private Integer uketukeno;

    public Integer getUketukeno() {
        return uketukeno;
    }

    public void setUketukeno(Integer pUketukeno) {
        uketukeno = pUketukeno;
    }

}