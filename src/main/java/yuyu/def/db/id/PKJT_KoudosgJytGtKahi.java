package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_KoudosgJytGtKahi;
import yuyu.def.db.mapping.GenJT_KoudosgJytGtKahi;
import yuyu.def.db.meta.GenQJT_KoudosgJytGtKahi;
import yuyu.def.db.meta.QJT_KoudosgJytGtKahi;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 高度障害状態該当可否テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_KoudosgJytGtKahi}</td><td colspan="3">高度障害状態該当可否テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ryougansitumeikbn</td><td>両眼失明区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KdsgJyoutaiGaitouKbn C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>ryougansitumeicomment</td><td>両眼失明コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gengososyakusousitukbn</td><td>言語・咀嚼機能喪失区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KdsgJyoutaiGaitouKbn C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>gengososyakusousitucomment</td><td>言語・咀嚼機能喪失コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ryoujyousiyoubousitukbn</td><td>両上肢用（亡）失区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KdsgJyoutaiGaitouKbn C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>ryoujyousiyoubousitucomt</td><td>両上肢用（亡）失コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ryoukasiyoubousitukbn</td><td>両下肢用（亡）失区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KdsgJyoutaiGaitouKbn C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>ryoukasiyoubousitucomt</td><td>両下肢用（亡）失コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ijyobosituikasiyositukbn</td><td>１上肢亡失・１下肢用（亡）失区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KdsgJyoutaiGaitouKbn C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>ijyobosituikasiyositucomt</td><td>１上肢亡失・１下肢用（亡）失コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ijyoyosituikasibositukbn</td><td>１上肢用失・１下肢亡失区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KdsgJyoutaiGaitouKbn C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>ijyoyosituikasibositucomt</td><td>１上肢用失・１下肢亡失コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sysnjoujikaigokbn</td><td>終身常時介護区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KdsgJyoutaiGaitouKbn C_KdsgJyoutaiGaitouKbn}</td></tr>
 *  <tr><td>sysnjoujikaigocomment</td><td>終身常時介護コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokoukbn</td><td>歩行区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>hokoucomment</td><td>歩行コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ihukutyakudatukbn</td><td>衣服着脱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>ihukutyakudatucomment</td><td>衣服着脱コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuuyokukbn</td><td>入浴区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>nyuuyokucomment</td><td>入浴コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syokumotusessyukbn</td><td>食物摂取区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>syokumotusessyucomment</td><td>食物摂取コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hukitorisimatukbn</td><td>拭き取り始末区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>hukitorisimatucomment</td><td>拭き取り始末コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haibenhainyoukbn</td><td>排便・排尿区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>haibenhainyoucomment</td><td>排便・排尿コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kikyokbn</td><td>起居区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn C_SysnJyoujiKaigoGaitouKbn}</td></tr>
 *  <tr><td>kikyocomment</td><td>起居コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_KoudosgJytGtKahi
 * @see     GenJT_KoudosgJytGtKahi
 * @see     QJT_KoudosgJytGtKahi
 * @see     GenQJT_KoudosgJytGtKahi
 */
public class PKJT_KoudosgJytGtKahi extends AbstractExDBPrimaryKey<JT_KoudosgJytGtKahi, PKJT_KoudosgJytGtKahi> {

    private static final long serialVersionUID = 1L;

    public PKJT_KoudosgJytGtKahi() {
    }

    public PKJT_KoudosgJytGtKahi(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
    }

    @Transient
    @Override
    public Class<JT_KoudosgJytGtKahi> getEntityClass() {
        return JT_KoudosgJytGtKahi.class;
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

}