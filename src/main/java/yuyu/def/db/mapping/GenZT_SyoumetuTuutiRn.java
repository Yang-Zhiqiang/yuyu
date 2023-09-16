package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SyoumetuTuutiRn;
import yuyu.def.db.id.PKZT_SyoumetuTuutiRn;
import yuyu.def.db.meta.GenQZT_SyoumetuTuutiRn;
import yuyu.def.db.meta.QZT_SyoumetuTuutiRn;

/**
 * 消滅通知Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SyoumetuTuutiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoumetuTuutiRn}</td><td colspan="3">消滅通知Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_SyoumetuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdkj zrntyouhyouymdkj}</td><td>（連携用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SyoumetuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantousitukbn zrntantousitukbn}</td><td>（連携用）担当室区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsksdoufuukbn zrnsksdoufuukbn}</td><td>（連携用）請求書同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmynosinkokuiraidoufuukbn zrnmynosinkokuiraidoufuukbn}</td><td>（連携用）マイナンバー申告依頼同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">{@link PKZT_SyoumetuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratemongonumukbn zrnkwsratemongonumukbn}</td><td>（連携用）為替レート文言有無区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv13 zrnyobiv13}</td><td>（連携用）予備項目Ｖ１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10 zrnansyuyouyobin10}</td><td>（連携用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskyno zrnshskyno}</td><td>（連携用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr1kj zrnshskadr1kj}</td><td>（連携用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr2kj zrnshskadr2kj}</td><td>（連携用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr3kj zrnshskadr3kj}</td><td>（連携用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkj zrnshsnmkj}</td><td>（連携用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv44 zrnyobiv44}</td><td>（連携用）予備項目Ｖ４４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x2 zrnansyuyouyobin10x2}</td><td>（連携用）案内収納用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawyno zrntawyno}</td><td>（連携用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr1kj zrntawadr1kj}</td><td>（連携用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr2kj zrntawadr2kj}</td><td>（連携用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr3kj zrntawadr3kj}</td><td>（連携用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoiawasekaisyanmkj zrntoiawasekaisyanmkj}</td><td>（連携用）問合せ先会社名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawsosikikj zrntawsosikikj}</td><td>（連携用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawtelnov14 zrntawtelnov14}</td><td>（連携用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou1x18keta zrntawteluktkkanou1x18keta}</td><td>（連携用）問合せ先電話受付可能時間１（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou2x18keta zrntawteluktkkanou2x18keta}</td><td>（連携用）問合せ先電話受付可能時間２（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv50 zrnyobiv50}</td><td>（連携用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x3 zrnansyuyouyobin10x3}</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon50keta1 zrnaisatumongon50keta1}</td><td>（連携用）挨拶文言（５０桁）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon50keta2 zrnaisatumongon50keta2}</td><td>（連携用）挨拶文言（５０桁）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon50keta3 zrnaisatumongon50keta3}</td><td>（連携用）挨拶文言（５０桁）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon50keta4 zrnaisatumongon50keta4}</td><td>（連携用）挨拶文言（５０桁）４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon50keta5 zrnaisatumongon50keta5}</td><td>（連携用）挨拶文言（５０桁）５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumongon50keta6 zrnaisatumongon50keta6}</td><td>（連携用）挨拶文言（５０桁）６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv120 zrnyobiv120}</td><td>（連携用）予備項目Ｖ１２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x4 zrnansyuyouyobin10x4}</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymdseireki zrnkykymdseireki}</td><td>（連携用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyurui30keta zrnhknsyurui30keta}</td><td>（連携用）保険種類（３０桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumetuymd zrnsyoumetuymd}</td><td>（連携用）消滅日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnoharaimodosikn zrnoharaimodosikn}</td><td>（連携用）お払戻金</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x5 zrnansyuyouyobin10x5}</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrymd11keta zrnshrymd11keta}</td><td>（連携用）支払日（１１桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou1 zrntekiyou1}</td><td>（連携用）摘要１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou1 zrnshrkngkmeisaihugou1}</td><td>（連携用）支払金額明細符号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai1 zrnshrgkmeisai1}</td><td>（連携用）支払金額明細１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu1 zrnshrgktuukasyu1}</td><td>（連携用）支払金額通貨種類１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou1 zrnbikou1}</td><td>（連携用）備考１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou2 zrntekiyou2}</td><td>（連携用）摘要２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou2 zrnshrkngkmeisaihugou2}</td><td>（連携用）支払金額明細符号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai2 zrnshrgkmeisai2}</td><td>（連携用）支払金額明細２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu2 zrnshrgktuukasyu2}</td><td>（連携用）支払金額通貨種類２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou2 zrnbikou2}</td><td>（連携用）備考２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou3 zrntekiyou3}</td><td>（連携用）摘要３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou3 zrnshrkngkmeisaihugou3}</td><td>（連携用）支払金額明細符号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai3 zrnshrgkmeisai3}</td><td>（連携用）支払金額明細３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu3 zrnshrgktuukasyu3}</td><td>（連携用）支払金額通貨種類３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou3 zrnbikou3}</td><td>（連携用）備考３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou4 zrntekiyou4}</td><td>（連携用）摘要４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou4 zrnshrkngkmeisaihugou4}</td><td>（連携用）支払金額明細符号４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai4 zrnshrgkmeisai4}</td><td>（連携用）支払金額明細４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu4 zrnshrgktuukasyu4}</td><td>（連携用）支払金額通貨種類４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou4 zrnbikou4}</td><td>（連携用）備考４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou5 zrntekiyou5}</td><td>（連携用）摘要５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou5 zrnshrkngkmeisaihugou5}</td><td>（連携用）支払金額明細符号５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai5 zrnshrgkmeisai5}</td><td>（連携用）支払金額明細５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu5 zrnshrgktuukasyu5}</td><td>（連携用）支払金額通貨種類５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou5 zrnbikou5}</td><td>（連携用）備考５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou6 zrntekiyou6}</td><td>（連携用）摘要６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou6 zrnshrkngkmeisaihugou6}</td><td>（連携用）支払金額明細符号６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai6 zrnshrgkmeisai6}</td><td>（連携用）支払金額明細６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu6 zrnshrgktuukasyu6}</td><td>（連携用）支払金額通貨種類６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou6 zrnbikou6}</td><td>（連携用）備考６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou7 zrntekiyou7}</td><td>（連携用）摘要７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou7 zrnshrkngkmeisaihugou7}</td><td>（連携用）支払金額明細符号７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai7 zrnshrgkmeisai7}</td><td>（連携用）支払金額明細７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu7 zrnshrgktuukasyu7}</td><td>（連携用）支払金額通貨種類７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou7 zrnbikou7}</td><td>（連携用）備考７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou8 zrntekiyou8}</td><td>（連携用）摘要８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou8 zrnshrkngkmeisaihugou8}</td><td>（連携用）支払金額明細符号８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai8 zrnshrgkmeisai8}</td><td>（連携用）支払金額明細８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu8 zrnshrgktuukasyu8}</td><td>（連携用）支払金額通貨種類８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou8 zrnbikou8}</td><td>（連携用）備考８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou9 zrntekiyou9}</td><td>（連携用）摘要９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou9 zrnshrkngkmeisaihugou9}</td><td>（連携用）支払金額明細符号９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai9 zrnshrgkmeisai9}</td><td>（連携用）支払金額明細９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu9 zrnshrgktuukasyu9}</td><td>（連携用）支払金額通貨種類９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou9 zrnbikou9}</td><td>（連携用）備考９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou10 zrntekiyou10}</td><td>（連携用）摘要１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou10 zrnshrkngkmeisaihugou10}</td><td>（連携用）支払金額明細符号１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai10 zrnshrgkmeisai10}</td><td>（連携用）支払金額明細１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu10 zrnshrgktuukasyu10}</td><td>（連携用）支払金額通貨種類１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou10 zrnbikou10}</td><td>（連携用）備考１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkgoukei zrnshrgkgoukei}</td><td>（連携用）支払額合計</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtuukasyu zrnshrtuukasyu}</td><td>（連携用）支払通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv215 zrnyobiv215}</td><td>（連携用）予備項目Ｖ２１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x6 zrnansyuyouyobin10x6}</td><td>（連携用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrnaiyouhskmongon1 zrnshrnaiyouhskmongon1}</td><td>（連携用）支払内容補足文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrnaiyouhskmongon2 zrnshrnaiyouhskmongon2}</td><td>（連携用）支払内容補足文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv40 zrnyobiv40}</td><td>（連携用）予備項目Ｖ４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x7 zrnansyuyouyobin10x7}</td><td>（連携用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbanknmkj zrnbanknmkj}</td><td>（連携用）銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitennmkj zrnsitennmkj}</td><td>（連携用）支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokinkbn zrnyokinkbn}</td><td>（連携用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzano12keta zrnkouzano12keta}</td><td>（連携用）口座番号（１２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzmeiginmknhan zrnkzmeiginmknhan}</td><td>（連携用）口座名義人氏名（カナ）（半角）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzsyurui zrnkzsyurui}</td><td>（連携用）口座種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv26x2 zrnyobiv26x2}</td><td>（連携用）予備項目Ｖ２６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x8 zrnansyuyouyobin10x8}</td><td>（連携用）案内収納用予備項目Ｎ１０＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsynykngk zrnsynykngk}</td><td>（連携用）収入金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsynykngktuukasyu zrnsynykngktuukasyu}</td><td>（連携用）収入金額通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtykeihi zrnhtykeihi}</td><td>（連携用）必要経費</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtykeihituukasyu zrnhtykeihituukasyu}</td><td>（連携用）必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkyksyahtykeihi zrnshrkyksyahtykeihi}</td><td>（連携用）お支払時の契約者の必要経費</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkykhtykeihituukasyu zrnshrkykhtykeihituukasyu}</td><td>（連携用）お支払時の契約者の必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngsbnrkzthtykeihi zrngsbnrkzthtykeihi}</td><td>（連携用）源泉分離課税対象の必要経費</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngsbnrkzthtykeihituksyu zrngsbnrkzthtykeihituksyu}</td><td>（連携用）源泉分離課税対象の必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngsbnrkztsaeki zrngsbnrkztsaeki}</td><td>（連携用）源泉分離課税対象の差益</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngsbnrkztsaekituksyu zrngsbnrkztsaekituksyu}</td><td>（連携用）源泉分離課税対象の差益通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimunaiyouhensyuctrlkbn zrnzeimunaiyouhensyuctrlkbn}</td><td>（連携用）税務内容編集制御区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongonoutkbn zrnzeimumongonoutkbn}</td><td>（連携用）税務文言出力区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon1 zrnzeimumongon1}</td><td>（連携用）税務文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon2 zrnzeimumongon2}</td><td>（連携用）税務文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon3 zrnzeimumongon3}</td><td>（連携用）税務文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon4 zrnzeimumongon4}</td><td>（連携用）税務文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon5 zrnzeimumongon5}</td><td>（連携用）税務文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyendthnkzeimuinfohskkbn zrnyendthnkzeimuinfohskkbn}</td><td>（連携用）円建変更時税務情報補足区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv74 zrnyobiv74}</td><td>（連携用）予備項目Ｖ７４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x9 zrnansyuyouyobin10x9}</td><td>（連携用）案内収納用予備項目Ｎ１０＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasehyoudai zrnosirasehyoudai}</td><td>（連携用）お知らせ表題</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon1 zrnosirasemongon1}</td><td>（連携用）お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon2 zrnosirasemongon2}</td><td>（連携用）お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon3 zrnosirasemongon3}</td><td>（連携用）お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon4 zrnosirasemongon4}</td><td>（連携用）お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon5 zrnosirasemongon5}</td><td>（連携用）お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon6 zrnosirasemongon6}</td><td>（連携用）お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon7 zrnosirasemongon7}</td><td>（連携用）お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon8 zrnosirasemongon8}</td><td>（連携用）お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon9 zrnosirasemongon9}</td><td>（連携用）お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon10 zrnosirasemongon10}</td><td>（連携用）お知らせ文言１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon11 zrnosirasemongon11}</td><td>（連携用）お知らせ文言１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon12 zrnosirasemongon12}</td><td>（連携用）お知らせ文言１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon13 zrnosirasemongon13}</td><td>（連携用）お知らせ文言１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon14 zrnosirasemongon14}</td><td>（連携用）お知らせ文言１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon15 zrnosirasemongon15}</td><td>（連携用）お知らせ文言１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon16 zrnosirasemongon16}</td><td>（連携用）お知らせ文言１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon17 zrnosirasemongon17}</td><td>（連携用）お知らせ文言１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon18 zrnosirasemongon18}</td><td>（連携用）お知らせ文言１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon19 zrnosirasemongon19}</td><td>（連携用）お知らせ文言１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon20 zrnosirasemongon20}</td><td>（連携用）お知らせ文言２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon21 zrnosirasemongon21}</td><td>（連携用）お知らせ文言２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon22 zrnosirasemongon22}</td><td>（連携用）お知らせ文言２２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon23 zrnosirasemongon23}</td><td>（連携用）お知らせ文言２３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon24 zrnosirasemongon24}</td><td>（連携用）お知らせ文言２４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon25 zrnosirasemongon25}</td><td>（連携用）お知らせ文言２５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon26 zrnosirasemongon26}</td><td>（連携用）お知らせ文言２６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon27 zrnosirasemongon27}</td><td>（連携用）お知らせ文言２７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon28 zrnosirasemongon28}</td><td>（連携用）お知らせ文言２８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon29 zrnosirasemongon29}</td><td>（連携用）お知らせ文言２９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon30 zrnosirasemongon30}</td><td>（連携用）お知らせ文言３０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon31 zrnosirasemongon31}</td><td>（連携用）お知らせ文言３１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon32 zrnosirasemongon32}</td><td>（連携用）お知らせ文言３２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon33 zrnosirasemongon33}</td><td>（連携用）お知らせ文言３３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon34 zrnosirasemongon34}</td><td>（連携用）お知らせ文言３４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon35 zrnosirasemongon35}</td><td>（連携用）お知らせ文言３５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon36 zrnosirasemongon36}</td><td>（連携用）お知らせ文言３６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon37 zrnosirasemongon37}</td><td>（連携用）お知らせ文言３７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon38 zrnosirasemongon38}</td><td>（連携用）お知らせ文言３８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon39 zrnosirasemongon39}</td><td>（連携用）お知らせ文言３９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon40 zrnosirasemongon40}</td><td>（連携用）お知らせ文言４０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon41 zrnosirasemongon41}</td><td>（連携用）お知らせ文言４１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon42 zrnosirasemongon42}</td><td>（連携用）お知らせ文言４２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon43 zrnosirasemongon43}</td><td>（連携用）お知らせ文言４３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon44 zrnosirasemongon44}</td><td>（連携用）お知らせ文言４４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon45 zrnosirasemongon45}</td><td>（連携用）お知らせ文言４５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46 zrnosirasemongon46}</td><td>（連携用）お知らせ文言４６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon47 zrnosirasemongon47}</td><td>（連携用）お知らせ文言４７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon48 zrnosirasemongon48}</td><td>（連携用）お知らせ文言４８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon49 zrnosirasemongon49}</td><td>（連携用）お知らせ文言４９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon50 zrnosirasemongon50}</td><td>（連携用）お知らせ文言５０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv255 zrnyobiv255}</td><td>（連携用）予備項目Ｖ２５５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x10 zrnansyuyouyobin10x10}</td><td>（連携用）案内収納用予備項目Ｎ１０＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteisyutusrmongon1 zrnteisyutusrmongon1}</td><td>（連携用）ご提出いただく書類文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteisyutusrmongon2 zrnteisyutusrmongon2}</td><td>（連携用）ご提出いただく書類文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteisyutusrmongon3 zrnteisyutusrmongon3}</td><td>（連携用）ご提出いただく書類文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmsgyobi1 zrnmsgyobi1}</td><td>（連携用）メッセージ予備項目１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x11 zrnansyuyouyobin10x11}</td><td>（連携用）案内収納用予備項目Ｎ１０＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyasyomeimongon1 zrnseikyuusyasyomeimongon1}</td><td>（連携用）請求者署名欄文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyasyomeimongon2 zrnseikyuusyasyomeimongon2}</td><td>（連携用）請求者署名欄文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyasyomeimongon3 zrnseikyuusyasyomeimongon3}</td><td>（連携用）請求者署名欄文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyasyomeimongon4 zrnseikyuusyasyomeimongon4}</td><td>（連携用）請求者署名欄文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyasyomeimongon5 zrnseikyuusyasyomeimongon5}</td><td>（連携用）請求者署名欄文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyasyomeimongon6 zrnseikyuusyasyomeimongon6}</td><td>（連携用）請求者署名欄文言６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyasyomeimongon7 zrnseikyuusyasyomeimongon7}</td><td>（連携用）請求者署名欄文言７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyasyomeimongon8 zrnseikyuusyasyomeimongon8}</td><td>（連携用）請求者署名欄文言８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyasyomeimongon9 zrnseikyuusyasyomeimongon9}</td><td>（連携用）請求者署名欄文言９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyagenyno zrnseikyuusyagenyno}</td><td>（連携用）請求者現住所郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyagenadr1 zrnseikyuusyagenadr1}</td><td>（連携用）請求者現住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyagenadr2 zrnseikyuusyagenadr2}</td><td>（連携用）請求者現住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuusyagenadr3 zrnseikyuusyagenadr3}</td><td>（連携用）請求者現住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikyuuyagentelno zrnseikyuuyagentelno}</td><td>（連携用）請求者現住所電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoritugisyasyozokunm zrntoritugisyasyozokunm}</td><td>（連携用）取次者所属名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoritugisyakjncd zrntoritugisyakjncd}</td><td>（連携用）取次者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoritugisyanm zrntoritugisyanm}</td><td>（連携用）取次者氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhozonkkny zrnhozonkkny}</td><td>（連携用）保存期間（年）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv168 zrnyobiv168}</td><td>（連携用）予備項目Ｖ１６８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnansyuyouyobin10x12 zrnansyuyouyobin10x12}</td><td>（連携用）案内収納用予備項目Ｎ１０＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteisyutusrmongon4 zrnteisyutusrmongon4}</td><td>（連携用）ご提出いただく書類文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv155 zrnyobiv155}</td><td>（連携用）予備項目Ｖ１５５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv97 zrnyobiv97}</td><td>（連携用）予備項目Ｖ９７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoumetuTuutiRn
 * @see     PKZT_SyoumetuTuutiRn
 * @see     QZT_SyoumetuTuutiRn
 * @see     GenQZT_SyoumetuTuutiRn
 */
@MappedSuperclass
@Table(name=GenZT_SyoumetuTuutiRn.TABLE_NAME)
@IdClass(value=PKZT_SyoumetuTuutiRn.class)
public abstract class GenZT_SyoumetuTuutiRn extends AbstractExDBEntityForZDB<ZT_SyoumetuTuutiRn, PKZT_SyoumetuTuutiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyoumetuTuutiRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNTYOUHYOUYMDKJ         = "zrntyouhyouymdkj";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNTANTOUSITUKBN         = "zrntantousitukbn";
    public static final String ZRNSKSDOUFUUKBN          = "zrnsksdoufuukbn";
    public static final String ZRNMYNOSINKOKUIRAIDOUFUUKBN = "zrnmynosinkokuiraidoufuukbn";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNKWSRATEMONGONUMUKBN   = "zrnkwsratemongonumukbn";
    public static final String ZRNYOBIV13               = "zrnyobiv13";
    public static final String ZRNANSYUYOUYOBIN10       = "zrnansyuyouyobin10";
    public static final String ZRNSHSKYNO               = "zrnshskyno";
    public static final String ZRNSHSKADR1KJ            = "zrnshskadr1kj";
    public static final String ZRNSHSKADR2KJ            = "zrnshskadr2kj";
    public static final String ZRNSHSKADR3KJ            = "zrnshskadr3kj";
    public static final String ZRNSHSNMKJ               = "zrnshsnmkj";
    public static final String ZRNYOBIV44               = "zrnyobiv44";
    public static final String ZRNANSYUYOUYOBIN10X2     = "zrnansyuyouyobin10x2";
    public static final String ZRNTAWYNO                = "zrntawyno";
    public static final String ZRNTAWADR1KJ             = "zrntawadr1kj";
    public static final String ZRNTAWADR2KJ             = "zrntawadr2kj";
    public static final String ZRNTAWADR3KJ             = "zrntawadr3kj";
    public static final String ZRNTOIAWASEKAISYANMKJ    = "zrntoiawasekaisyanmkj";
    public static final String ZRNTAWSOSIKIKJ           = "zrntawsosikikj";
    public static final String ZRNTAWTELNOV14           = "zrntawtelnov14";
    public static final String ZRNTAWTELUKTKKANOU1X18KETA = "zrntawteluktkkanou1x18keta";
    public static final String ZRNTAWTELUKTKKANOU2X18KETA = "zrntawteluktkkanou2x18keta";
    public static final String ZRNYOBIV50               = "zrnyobiv50";
    public static final String ZRNANSYUYOUYOBIN10X3     = "zrnansyuyouyobin10x3";
    public static final String ZRNAISATUMONGON50KETA1   = "zrnaisatumongon50keta1";
    public static final String ZRNAISATUMONGON50KETA2   = "zrnaisatumongon50keta2";
    public static final String ZRNAISATUMONGON50KETA3   = "zrnaisatumongon50keta3";
    public static final String ZRNAISATUMONGON50KETA4   = "zrnaisatumongon50keta4";
    public static final String ZRNAISATUMONGON50KETA5   = "zrnaisatumongon50keta5";
    public static final String ZRNAISATUMONGON50KETA6   = "zrnaisatumongon50keta6";
    public static final String ZRNYOBIV120              = "zrnyobiv120";
    public static final String ZRNANSYUYOUYOBIN10X4     = "zrnansyuyouyobin10x4";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNKYKYMDSEIREKI         = "zrnkykymdseireki";
    public static final String ZRNHKNSYURUI30KETA       = "zrnhknsyurui30keta";
    public static final String ZRNSYOUMETUYMD           = "zrnsyoumetuymd";
    public static final String ZRNOHARAIMODOSIKN        = "zrnoharaimodosikn";
    public static final String ZRNYOBIV20               = "zrnyobiv20";
    public static final String ZRNANSYUYOUYOBIN10X5     = "zrnansyuyouyobin10x5";
    public static final String ZRNSHRYMD11KETA          = "zrnshrymd11keta";
    public static final String ZRNTEKIYOU1              = "zrntekiyou1";
    public static final String ZRNSHRKNGKMEISAIHUGOU1   = "zrnshrkngkmeisaihugou1";
    public static final String ZRNSHRGKMEISAI1          = "zrnshrgkmeisai1";
    public static final String ZRNSHRGKTUUKASYU1        = "zrnshrgktuukasyu1";
    public static final String ZRNBIKOU1                = "zrnbikou1";
    public static final String ZRNTEKIYOU2              = "zrntekiyou2";
    public static final String ZRNSHRKNGKMEISAIHUGOU2   = "zrnshrkngkmeisaihugou2";
    public static final String ZRNSHRGKMEISAI2          = "zrnshrgkmeisai2";
    public static final String ZRNSHRGKTUUKASYU2        = "zrnshrgktuukasyu2";
    public static final String ZRNBIKOU2                = "zrnbikou2";
    public static final String ZRNTEKIYOU3              = "zrntekiyou3";
    public static final String ZRNSHRKNGKMEISAIHUGOU3   = "zrnshrkngkmeisaihugou3";
    public static final String ZRNSHRGKMEISAI3          = "zrnshrgkmeisai3";
    public static final String ZRNSHRGKTUUKASYU3        = "zrnshrgktuukasyu3";
    public static final String ZRNBIKOU3                = "zrnbikou3";
    public static final String ZRNTEKIYOU4              = "zrntekiyou4";
    public static final String ZRNSHRKNGKMEISAIHUGOU4   = "zrnshrkngkmeisaihugou4";
    public static final String ZRNSHRGKMEISAI4          = "zrnshrgkmeisai4";
    public static final String ZRNSHRGKTUUKASYU4        = "zrnshrgktuukasyu4";
    public static final String ZRNBIKOU4                = "zrnbikou4";
    public static final String ZRNTEKIYOU5              = "zrntekiyou5";
    public static final String ZRNSHRKNGKMEISAIHUGOU5   = "zrnshrkngkmeisaihugou5";
    public static final String ZRNSHRGKMEISAI5          = "zrnshrgkmeisai5";
    public static final String ZRNSHRGKTUUKASYU5        = "zrnshrgktuukasyu5";
    public static final String ZRNBIKOU5                = "zrnbikou5";
    public static final String ZRNTEKIYOU6              = "zrntekiyou6";
    public static final String ZRNSHRKNGKMEISAIHUGOU6   = "zrnshrkngkmeisaihugou6";
    public static final String ZRNSHRGKMEISAI6          = "zrnshrgkmeisai6";
    public static final String ZRNSHRGKTUUKASYU6        = "zrnshrgktuukasyu6";
    public static final String ZRNBIKOU6                = "zrnbikou6";
    public static final String ZRNTEKIYOU7              = "zrntekiyou7";
    public static final String ZRNSHRKNGKMEISAIHUGOU7   = "zrnshrkngkmeisaihugou7";
    public static final String ZRNSHRGKMEISAI7          = "zrnshrgkmeisai7";
    public static final String ZRNSHRGKTUUKASYU7        = "zrnshrgktuukasyu7";
    public static final String ZRNBIKOU7                = "zrnbikou7";
    public static final String ZRNTEKIYOU8              = "zrntekiyou8";
    public static final String ZRNSHRKNGKMEISAIHUGOU8   = "zrnshrkngkmeisaihugou8";
    public static final String ZRNSHRGKMEISAI8          = "zrnshrgkmeisai8";
    public static final String ZRNSHRGKTUUKASYU8        = "zrnshrgktuukasyu8";
    public static final String ZRNBIKOU8                = "zrnbikou8";
    public static final String ZRNTEKIYOU9              = "zrntekiyou9";
    public static final String ZRNSHRKNGKMEISAIHUGOU9   = "zrnshrkngkmeisaihugou9";
    public static final String ZRNSHRGKMEISAI9          = "zrnshrgkmeisai9";
    public static final String ZRNSHRGKTUUKASYU9        = "zrnshrgktuukasyu9";
    public static final String ZRNBIKOU9                = "zrnbikou9";
    public static final String ZRNTEKIYOU10             = "zrntekiyou10";
    public static final String ZRNSHRKNGKMEISAIHUGOU10  = "zrnshrkngkmeisaihugou10";
    public static final String ZRNSHRGKMEISAI10         = "zrnshrgkmeisai10";
    public static final String ZRNSHRGKTUUKASYU10       = "zrnshrgktuukasyu10";
    public static final String ZRNBIKOU10               = "zrnbikou10";
    public static final String ZRNSHRGKGOUKEI           = "zrnshrgkgoukei";
    public static final String ZRNSHRTUUKASYU           = "zrnshrtuukasyu";
    public static final String ZRNYOBIV215              = "zrnyobiv215";
    public static final String ZRNANSYUYOUYOBIN10X6     = "zrnansyuyouyobin10x6";
    public static final String ZRNSHRNAIYOUHSKMONGON1   = "zrnshrnaiyouhskmongon1";
    public static final String ZRNSHRNAIYOUHSKMONGON2   = "zrnshrnaiyouhskmongon2";
    public static final String ZRNYOBIV40               = "zrnyobiv40";
    public static final String ZRNANSYUYOUYOBIN10X7     = "zrnansyuyouyobin10x7";
    public static final String ZRNBANKNMKJ              = "zrnbanknmkj";
    public static final String ZRNSITENNMKJ             = "zrnsitennmkj";
    public static final String ZRNYOKINKBN              = "zrnyokinkbn";
    public static final String ZRNKOUZANO12KETA         = "zrnkouzano12keta";
    public static final String ZRNKZMEIGINMKNHAN        = "zrnkzmeiginmknhan";
    public static final String ZRNKZSYURUI              = "zrnkzsyurui";
    public static final String ZRNYOBIV26X2             = "zrnyobiv26x2";
    public static final String ZRNANSYUYOUYOBIN10X8     = "zrnansyuyouyobin10x8";
    public static final String ZRNSYNYKNGK              = "zrnsynykngk";
    public static final String ZRNSYNYKNGKTUUKASYU      = "zrnsynykngktuukasyu";
    public static final String ZRNHTYKEIHI              = "zrnhtykeihi";
    public static final String ZRNHTYKEIHITUUKASYU      = "zrnhtykeihituukasyu";
    public static final String ZRNSHRKYKSYAHTYKEIHI     = "zrnshrkyksyahtykeihi";
    public static final String ZRNSHRKYKHTYKEIHITUUKASYU = "zrnshrkykhtykeihituukasyu";
    public static final String ZRNGSBNRKZTHTYKEIHI      = "zrngsbnrkzthtykeihi";
    public static final String ZRNGSBNRKZTHTYKEIHITUKSYU = "zrngsbnrkzthtykeihituksyu";
    public static final String ZRNGSBNRKZTSAEKI         = "zrngsbnrkztsaeki";
    public static final String ZRNGSBNRKZTSAEKITUKSYU   = "zrngsbnrkztsaekituksyu";
    public static final String ZRNZEIMUNAIYOUHENSYUCTRLKBN = "zrnzeimunaiyouhensyuctrlkbn";
    public static final String ZRNZEIMUMONGONOUTKBN     = "zrnzeimumongonoutkbn";
    public static final String ZRNZEIMUMONGON1          = "zrnzeimumongon1";
    public static final String ZRNZEIMUMONGON2          = "zrnzeimumongon2";
    public static final String ZRNZEIMUMONGON3          = "zrnzeimumongon3";
    public static final String ZRNZEIMUMONGON4          = "zrnzeimumongon4";
    public static final String ZRNZEIMUMONGON5          = "zrnzeimumongon5";
    public static final String ZRNYENDTHNKZEIMUINFOHSKKBN = "zrnyendthnkzeimuinfohskkbn";
    public static final String ZRNYOBIV74               = "zrnyobiv74";
    public static final String ZRNANSYUYOUYOBIN10X9     = "zrnansyuyouyobin10x9";
    public static final String ZRNOSIRASEHYOUDAI        = "zrnosirasehyoudai";
    public static final String ZRNOSIRASEMONGON1        = "zrnosirasemongon1";
    public static final String ZRNOSIRASEMONGON2        = "zrnosirasemongon2";
    public static final String ZRNOSIRASEMONGON3        = "zrnosirasemongon3";
    public static final String ZRNOSIRASEMONGON4        = "zrnosirasemongon4";
    public static final String ZRNOSIRASEMONGON5        = "zrnosirasemongon5";
    public static final String ZRNOSIRASEMONGON6        = "zrnosirasemongon6";
    public static final String ZRNOSIRASEMONGON7        = "zrnosirasemongon7";
    public static final String ZRNOSIRASEMONGON8        = "zrnosirasemongon8";
    public static final String ZRNOSIRASEMONGON9        = "zrnosirasemongon9";
    public static final String ZRNOSIRASEMONGON10       = "zrnosirasemongon10";
    public static final String ZRNOSIRASEMONGON11       = "zrnosirasemongon11";
    public static final String ZRNOSIRASEMONGON12       = "zrnosirasemongon12";
    public static final String ZRNOSIRASEMONGON13       = "zrnosirasemongon13";
    public static final String ZRNOSIRASEMONGON14       = "zrnosirasemongon14";
    public static final String ZRNOSIRASEMONGON15       = "zrnosirasemongon15";
    public static final String ZRNOSIRASEMONGON16       = "zrnosirasemongon16";
    public static final String ZRNOSIRASEMONGON17       = "zrnosirasemongon17";
    public static final String ZRNOSIRASEMONGON18       = "zrnosirasemongon18";
    public static final String ZRNOSIRASEMONGON19       = "zrnosirasemongon19";
    public static final String ZRNOSIRASEMONGON20       = "zrnosirasemongon20";
    public static final String ZRNOSIRASEMONGON21       = "zrnosirasemongon21";
    public static final String ZRNOSIRASEMONGON22       = "zrnosirasemongon22";
    public static final String ZRNOSIRASEMONGON23       = "zrnosirasemongon23";
    public static final String ZRNOSIRASEMONGON24       = "zrnosirasemongon24";
    public static final String ZRNOSIRASEMONGON25       = "zrnosirasemongon25";
    public static final String ZRNOSIRASEMONGON26       = "zrnosirasemongon26";
    public static final String ZRNOSIRASEMONGON27       = "zrnosirasemongon27";
    public static final String ZRNOSIRASEMONGON28       = "zrnosirasemongon28";
    public static final String ZRNOSIRASEMONGON29       = "zrnosirasemongon29";
    public static final String ZRNOSIRASEMONGON30       = "zrnosirasemongon30";
    public static final String ZRNOSIRASEMONGON31       = "zrnosirasemongon31";
    public static final String ZRNOSIRASEMONGON32       = "zrnosirasemongon32";
    public static final String ZRNOSIRASEMONGON33       = "zrnosirasemongon33";
    public static final String ZRNOSIRASEMONGON34       = "zrnosirasemongon34";
    public static final String ZRNOSIRASEMONGON35       = "zrnosirasemongon35";
    public static final String ZRNOSIRASEMONGON36       = "zrnosirasemongon36";
    public static final String ZRNOSIRASEMONGON37       = "zrnosirasemongon37";
    public static final String ZRNOSIRASEMONGON38       = "zrnosirasemongon38";
    public static final String ZRNOSIRASEMONGON39       = "zrnosirasemongon39";
    public static final String ZRNOSIRASEMONGON40       = "zrnosirasemongon40";
    public static final String ZRNOSIRASEMONGON41       = "zrnosirasemongon41";
    public static final String ZRNOSIRASEMONGON42       = "zrnosirasemongon42";
    public static final String ZRNOSIRASEMONGON43       = "zrnosirasemongon43";
    public static final String ZRNOSIRASEMONGON44       = "zrnosirasemongon44";
    public static final String ZRNOSIRASEMONGON45       = "zrnosirasemongon45";
    public static final String ZRNOSIRASEMONGON46       = "zrnosirasemongon46";
    public static final String ZRNOSIRASEMONGON47       = "zrnosirasemongon47";
    public static final String ZRNOSIRASEMONGON48       = "zrnosirasemongon48";
    public static final String ZRNOSIRASEMONGON49       = "zrnosirasemongon49";
    public static final String ZRNOSIRASEMONGON50       = "zrnosirasemongon50";
    public static final String ZRNYOBIV255              = "zrnyobiv255";
    public static final String ZRNANSYUYOUYOBIN10X10    = "zrnansyuyouyobin10x10";
    public static final String ZRNTEISYUTUSRMONGON1     = "zrnteisyutusrmongon1";
    public static final String ZRNTEISYUTUSRMONGON2     = "zrnteisyutusrmongon2";
    public static final String ZRNTEISYUTUSRMONGON3     = "zrnteisyutusrmongon3";
    public static final String ZRNMSGYOBI1              = "zrnmsgyobi1";
    public static final String ZRNANSYUYOUYOBIN10X11    = "zrnansyuyouyobin10x11";
    public static final String ZRNSEIKYUUSYASYOMEIMONGON1 = "zrnseikyuusyasyomeimongon1";
    public static final String ZRNSEIKYUUSYASYOMEIMONGON2 = "zrnseikyuusyasyomeimongon2";
    public static final String ZRNSEIKYUUSYASYOMEIMONGON3 = "zrnseikyuusyasyomeimongon3";
    public static final String ZRNSEIKYUUSYASYOMEIMONGON4 = "zrnseikyuusyasyomeimongon4";
    public static final String ZRNSEIKYUUSYASYOMEIMONGON5 = "zrnseikyuusyasyomeimongon5";
    public static final String ZRNSEIKYUUSYASYOMEIMONGON6 = "zrnseikyuusyasyomeimongon6";
    public static final String ZRNSEIKYUUSYASYOMEIMONGON7 = "zrnseikyuusyasyomeimongon7";
    public static final String ZRNSEIKYUUSYASYOMEIMONGON8 = "zrnseikyuusyasyomeimongon8";
    public static final String ZRNSEIKYUUSYASYOMEIMONGON9 = "zrnseikyuusyasyomeimongon9";
    public static final String ZRNSEIKYUUSYAGENYNO      = "zrnseikyuusyagenyno";
    public static final String ZRNSEIKYUUSYAGENADR1     = "zrnseikyuusyagenadr1";
    public static final String ZRNSEIKYUUSYAGENADR2     = "zrnseikyuusyagenadr2";
    public static final String ZRNSEIKYUUSYAGENADR3     = "zrnseikyuusyagenadr3";
    public static final String ZRNSEIKYUUYAGENTELNO     = "zrnseikyuuyagentelno";
    public static final String ZRNTORITUGISYASYOZOKUNM  = "zrntoritugisyasyozokunm";
    public static final String ZRNTORITUGISYAKJNCD      = "zrntoritugisyakjncd";
    public static final String ZRNTORITUGISYANM         = "zrntoritugisyanm";
    public static final String ZRNHOZONKKNY             = "zrnhozonkkny";
    public static final String ZRNYOBIV168              = "zrnyobiv168";
    public static final String ZRNANSYUYOUYOBIN10X12    = "zrnansyuyouyobin10x12";
    public static final String ZRNTEISYUTUSRMONGON4     = "zrnteisyutusrmongon4";
    public static final String ZRNYOBIV155              = "zrnyobiv155";
    public static final String ZRNYOBIV97               = "zrnyobiv97";

    private final PKZT_SyoumetuTuutiRn primaryKey;

    public GenZT_SyoumetuTuutiRn() {
        primaryKey = new PKZT_SyoumetuTuutiRn();
    }

    public GenZT_SyoumetuTuutiRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        primaryKey = new PKZT_SyoumetuTuutiRn(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_SyoumetuTuutiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyoumetuTuutiRn> getMetaClass() {
        return QZT_SyoumetuTuutiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdkj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTYOUHYOUYMDKJ)
    public String getZrntyouhyouymdkj() {
        return zrntyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdkj(String pZrntyouhyouymdkj) {
        zrntyouhyouymdkj = pZrntyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrntantousitukbn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTANTOUSITUKBN)
    public String getZrntantousitukbn() {
        return zrntantousitukbn;
    }

    public void setZrntantousitukbn(String pZrntantousitukbn) {
        zrntantousitukbn = pZrntantousitukbn;
    }

    private String zrnsksdoufuukbn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSKSDOUFUUKBN)
    public String getZrnsksdoufuukbn() {
        return zrnsksdoufuukbn;
    }

    public void setZrnsksdoufuukbn(String pZrnsksdoufuukbn) {
        zrnsksdoufuukbn = pZrnsksdoufuukbn;
    }

    private String zrnmynosinkokuiraidoufuukbn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNMYNOSINKOKUIRAIDOUFUUKBN)
    public String getZrnmynosinkokuiraidoufuukbn() {
        return zrnmynosinkokuiraidoufuukbn;
    }

    public void setZrnmynosinkokuiraidoufuukbn(String pZrnmynosinkokuiraidoufuukbn) {
        zrnmynosinkokuiraidoufuukbn = pZrnmynosinkokuiraidoufuukbn;
    }

    @Id
    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return getPrimaryKey().getZrnsikibetuno();
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        getPrimaryKey().setZrnsikibetuno(pZrnsikibetuno);
    }

    private String zrnkwsratemongonumukbn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNKWSRATEMONGONUMUKBN)
    public String getZrnkwsratemongonumukbn() {
        return zrnkwsratemongonumukbn;
    }

    public void setZrnkwsratemongonumukbn(String pZrnkwsratemongonumukbn) {
        zrnkwsratemongonumukbn = pZrnkwsratemongonumukbn;
    }

    private String zrnyobiv13;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV13)
    public String getZrnyobiv13() {
        return zrnyobiv13;
    }

    public void setZrnyobiv13(String pZrnyobiv13) {
        zrnyobiv13 = pZrnyobiv13;
    }

    private String zrnansyuyouyobin10;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10)
    public String getZrnansyuyouyobin10() {
        return zrnansyuyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10(String pZrnansyuyouyobin10) {
        zrnansyuyouyobin10 = pZrnansyuyouyobin10;
    }

    private String zrnshskyno;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHSNMKJ)
    public String getZrnshsnmkj() {
        return zrnshsnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkj(String pZrnshsnmkj) {
        zrnshsnmkj = pZrnshsnmkj;
    }

    private String zrnyobiv44;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV44)
    public String getZrnyobiv44() {
        return zrnyobiv44;
    }

    public void setZrnyobiv44(String pZrnyobiv44) {
        zrnyobiv44 = pZrnyobiv44;
    }

    private String zrnansyuyouyobin10x2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X2)
    public String getZrnansyuyouyobin10x2() {
        return zrnansyuyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x2(String pZrnansyuyouyobin10x2) {
        zrnansyuyouyobin10x2 = pZrnansyuyouyobin10x2;
    }

    private String zrntawyno;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntoiawasekaisyanmkj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTOIAWASEKAISYANMKJ)
    public String getZrntoiawasekaisyanmkj() {
        return zrntoiawasekaisyanmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntoiawasekaisyanmkj(String pZrntoiawasekaisyanmkj) {
        zrntoiawasekaisyanmkj = pZrntoiawasekaisyanmkj;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1x18keta;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTAWTELUKTKKANOU1X18KETA)
    public String getZrntawteluktkkanou1x18keta() {
        return zrntawteluktkkanou1x18keta;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1x18keta(String pZrntawteluktkkanou1x18keta) {
        zrntawteluktkkanou1x18keta = pZrntawteluktkkanou1x18keta;
    }

    private String zrntawteluktkkanou2x18keta;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTAWTELUKTKKANOU2X18KETA)
    public String getZrntawteluktkkanou2x18keta() {
        return zrntawteluktkkanou2x18keta;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2x18keta(String pZrntawteluktkkanou2x18keta) {
        zrntawteluktkkanou2x18keta = pZrntawteluktkkanou2x18keta;
    }

    private String zrnyobiv50;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV50)
    public String getZrnyobiv50() {
        return zrnyobiv50;
    }

    public void setZrnyobiv50(String pZrnyobiv50) {
        zrnyobiv50 = pZrnyobiv50;
    }

    private String zrnansyuyouyobin10x3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X3)
    public String getZrnansyuyouyobin10x3() {
        return zrnansyuyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x3(String pZrnansyuyouyobin10x3) {
        zrnansyuyouyobin10x3 = pZrnansyuyouyobin10x3;
    }

    private String zrnaisatumongon50keta1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNAISATUMONGON50KETA1)
    public String getZrnaisatumongon50keta1() {
        return zrnaisatumongon50keta1;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon50keta1(String pZrnaisatumongon50keta1) {
        zrnaisatumongon50keta1 = pZrnaisatumongon50keta1;
    }

    private String zrnaisatumongon50keta2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNAISATUMONGON50KETA2)
    public String getZrnaisatumongon50keta2() {
        return zrnaisatumongon50keta2;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon50keta2(String pZrnaisatumongon50keta2) {
        zrnaisatumongon50keta2 = pZrnaisatumongon50keta2;
    }

    private String zrnaisatumongon50keta3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNAISATUMONGON50KETA3)
    public String getZrnaisatumongon50keta3() {
        return zrnaisatumongon50keta3;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon50keta3(String pZrnaisatumongon50keta3) {
        zrnaisatumongon50keta3 = pZrnaisatumongon50keta3;
    }

    private String zrnaisatumongon50keta4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNAISATUMONGON50KETA4)
    public String getZrnaisatumongon50keta4() {
        return zrnaisatumongon50keta4;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon50keta4(String pZrnaisatumongon50keta4) {
        zrnaisatumongon50keta4 = pZrnaisatumongon50keta4;
    }

    private String zrnaisatumongon50keta5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNAISATUMONGON50KETA5)
    public String getZrnaisatumongon50keta5() {
        return zrnaisatumongon50keta5;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon50keta5(String pZrnaisatumongon50keta5) {
        zrnaisatumongon50keta5 = pZrnaisatumongon50keta5;
    }

    private String zrnaisatumongon50keta6;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNAISATUMONGON50KETA6)
    public String getZrnaisatumongon50keta6() {
        return zrnaisatumongon50keta6;
    }

    @DataConvert("toMultiByte")
    public void setZrnaisatumongon50keta6(String pZrnaisatumongon50keta6) {
        zrnaisatumongon50keta6 = pZrnaisatumongon50keta6;
    }

    private String zrnyobiv120;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV120)
    public String getZrnyobiv120() {
        return zrnyobiv120;
    }

    public void setZrnyobiv120(String pZrnyobiv120) {
        zrnyobiv120 = pZrnyobiv120;
    }

    private String zrnansyuyouyobin10x4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X4)
    public String getZrnansyuyouyobin10x4() {
        return zrnansyuyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x4(String pZrnansyuyouyobin10x4) {
        zrnansyuyouyobin10x4 = pZrnansyuyouyobin10x4;
    }

    private String zrnsyono2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnkykymdseireki;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNKYKYMDSEIREKI)
    public String getZrnkykymdseireki() {
        return zrnkykymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykymdseireki(String pZrnkykymdseireki) {
        zrnkykymdseireki = pZrnkykymdseireki;
    }

    private String zrnhknsyurui30keta;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNHKNSYURUI30KETA)
    public String getZrnhknsyurui30keta() {
        return zrnhknsyurui30keta;
    }

    @DataConvert("toMultiByte")
    public void setZrnhknsyurui30keta(String pZrnhknsyurui30keta) {
        zrnhknsyurui30keta = pZrnhknsyurui30keta;
    }

    private String zrnsyoumetuymd;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSYOUMETUYMD)
    public String getZrnsyoumetuymd() {
        return zrnsyoumetuymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyoumetuymd(String pZrnsyoumetuymd) {
        zrnsyoumetuymd = pZrnsyoumetuymd;
    }

    private String zrnoharaimodosikn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOHARAIMODOSIKN)
    public String getZrnoharaimodosikn() {
        return zrnoharaimodosikn;
    }

    public void setZrnoharaimodosikn(String pZrnoharaimodosikn) {
        zrnoharaimodosikn = pZrnoharaimodosikn;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }

    private String zrnansyuyouyobin10x5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X5)
    public String getZrnansyuyouyobin10x5() {
        return zrnansyuyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x5(String pZrnansyuyouyobin10x5) {
        zrnansyuyouyobin10x5 = pZrnansyuyouyobin10x5;
    }

    private String zrnshrymd11keta;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRYMD11KETA)
    public String getZrnshrymd11keta() {
        return zrnshrymd11keta;
    }

    @DataConvert("toMultiByte")
    public void setZrnshrymd11keta(String pZrnshrymd11keta) {
        zrnshrymd11keta = pZrnshrymd11keta;
    }

    private String zrntekiyou1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU1)
    public String getZrntekiyou1() {
        return zrntekiyou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou1(String pZrntekiyou1) {
        zrntekiyou1 = pZrntekiyou1;
    }

    private String zrnshrkngkmeisaihugou1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU1)
    public String getZrnshrkngkmeisaihugou1() {
        return zrnshrkngkmeisaihugou1;
    }

    public void setZrnshrkngkmeisaihugou1(String pZrnshrkngkmeisaihugou1) {
        zrnshrkngkmeisaihugou1 = pZrnshrkngkmeisaihugou1;
    }

    private String zrnshrgkmeisai1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI1)
    public String getZrnshrgkmeisai1() {
        return zrnshrgkmeisai1;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai1(String pZrnshrgkmeisai1) {
        zrnshrgkmeisai1 = pZrnshrgkmeisai1;
    }

    private String zrnshrgktuukasyu1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU1)
    public String getZrnshrgktuukasyu1() {
        return zrnshrgktuukasyu1;
    }

    public void setZrnshrgktuukasyu1(String pZrnshrgktuukasyu1) {
        zrnshrgktuukasyu1 = pZrnshrgktuukasyu1;
    }

    private String zrnbikou1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU1)
    public String getZrnbikou1() {
        return zrnbikou1;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou1(String pZrnbikou1) {
        zrnbikou1 = pZrnbikou1;
    }

    private String zrntekiyou2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU2)
    public String getZrntekiyou2() {
        return zrntekiyou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou2(String pZrntekiyou2) {
        zrntekiyou2 = pZrntekiyou2;
    }

    private String zrnshrkngkmeisaihugou2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU2)
    public String getZrnshrkngkmeisaihugou2() {
        return zrnshrkngkmeisaihugou2;
    }

    public void setZrnshrkngkmeisaihugou2(String pZrnshrkngkmeisaihugou2) {
        zrnshrkngkmeisaihugou2 = pZrnshrkngkmeisaihugou2;
    }

    private String zrnshrgkmeisai2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI2)
    public String getZrnshrgkmeisai2() {
        return zrnshrgkmeisai2;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai2(String pZrnshrgkmeisai2) {
        zrnshrgkmeisai2 = pZrnshrgkmeisai2;
    }

    private String zrnshrgktuukasyu2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU2)
    public String getZrnshrgktuukasyu2() {
        return zrnshrgktuukasyu2;
    }

    public void setZrnshrgktuukasyu2(String pZrnshrgktuukasyu2) {
        zrnshrgktuukasyu2 = pZrnshrgktuukasyu2;
    }

    private String zrnbikou2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU2)
    public String getZrnbikou2() {
        return zrnbikou2;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou2(String pZrnbikou2) {
        zrnbikou2 = pZrnbikou2;
    }

    private String zrntekiyou3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU3)
    public String getZrntekiyou3() {
        return zrntekiyou3;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou3(String pZrntekiyou3) {
        zrntekiyou3 = pZrntekiyou3;
    }

    private String zrnshrkngkmeisaihugou3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU3)
    public String getZrnshrkngkmeisaihugou3() {
        return zrnshrkngkmeisaihugou3;
    }

    public void setZrnshrkngkmeisaihugou3(String pZrnshrkngkmeisaihugou3) {
        zrnshrkngkmeisaihugou3 = pZrnshrkngkmeisaihugou3;
    }

    private String zrnshrgkmeisai3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI3)
    public String getZrnshrgkmeisai3() {
        return zrnshrgkmeisai3;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai3(String pZrnshrgkmeisai3) {
        zrnshrgkmeisai3 = pZrnshrgkmeisai3;
    }

    private String zrnshrgktuukasyu3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU3)
    public String getZrnshrgktuukasyu3() {
        return zrnshrgktuukasyu3;
    }

    public void setZrnshrgktuukasyu3(String pZrnshrgktuukasyu3) {
        zrnshrgktuukasyu3 = pZrnshrgktuukasyu3;
    }

    private String zrnbikou3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU3)
    public String getZrnbikou3() {
        return zrnbikou3;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou3(String pZrnbikou3) {
        zrnbikou3 = pZrnbikou3;
    }

    private String zrntekiyou4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU4)
    public String getZrntekiyou4() {
        return zrntekiyou4;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou4(String pZrntekiyou4) {
        zrntekiyou4 = pZrntekiyou4;
    }

    private String zrnshrkngkmeisaihugou4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU4)
    public String getZrnshrkngkmeisaihugou4() {
        return zrnshrkngkmeisaihugou4;
    }

    public void setZrnshrkngkmeisaihugou4(String pZrnshrkngkmeisaihugou4) {
        zrnshrkngkmeisaihugou4 = pZrnshrkngkmeisaihugou4;
    }

    private String zrnshrgkmeisai4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI4)
    public String getZrnshrgkmeisai4() {
        return zrnshrgkmeisai4;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai4(String pZrnshrgkmeisai4) {
        zrnshrgkmeisai4 = pZrnshrgkmeisai4;
    }

    private String zrnshrgktuukasyu4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU4)
    public String getZrnshrgktuukasyu4() {
        return zrnshrgktuukasyu4;
    }

    public void setZrnshrgktuukasyu4(String pZrnshrgktuukasyu4) {
        zrnshrgktuukasyu4 = pZrnshrgktuukasyu4;
    }

    private String zrnbikou4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU4)
    public String getZrnbikou4() {
        return zrnbikou4;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou4(String pZrnbikou4) {
        zrnbikou4 = pZrnbikou4;
    }

    private String zrntekiyou5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU5)
    public String getZrntekiyou5() {
        return zrntekiyou5;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou5(String pZrntekiyou5) {
        zrntekiyou5 = pZrntekiyou5;
    }

    private String zrnshrkngkmeisaihugou5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU5)
    public String getZrnshrkngkmeisaihugou5() {
        return zrnshrkngkmeisaihugou5;
    }

    public void setZrnshrkngkmeisaihugou5(String pZrnshrkngkmeisaihugou5) {
        zrnshrkngkmeisaihugou5 = pZrnshrkngkmeisaihugou5;
    }

    private String zrnshrgkmeisai5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI5)
    public String getZrnshrgkmeisai5() {
        return zrnshrgkmeisai5;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai5(String pZrnshrgkmeisai5) {
        zrnshrgkmeisai5 = pZrnshrgkmeisai5;
    }

    private String zrnshrgktuukasyu5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU5)
    public String getZrnshrgktuukasyu5() {
        return zrnshrgktuukasyu5;
    }

    public void setZrnshrgktuukasyu5(String pZrnshrgktuukasyu5) {
        zrnshrgktuukasyu5 = pZrnshrgktuukasyu5;
    }

    private String zrnbikou5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU5)
    public String getZrnbikou5() {
        return zrnbikou5;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou5(String pZrnbikou5) {
        zrnbikou5 = pZrnbikou5;
    }

    private String zrntekiyou6;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU6)
    public String getZrntekiyou6() {
        return zrntekiyou6;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou6(String pZrntekiyou6) {
        zrntekiyou6 = pZrntekiyou6;
    }

    private String zrnshrkngkmeisaihugou6;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU6)
    public String getZrnshrkngkmeisaihugou6() {
        return zrnshrkngkmeisaihugou6;
    }

    public void setZrnshrkngkmeisaihugou6(String pZrnshrkngkmeisaihugou6) {
        zrnshrkngkmeisaihugou6 = pZrnshrkngkmeisaihugou6;
    }

    private String zrnshrgkmeisai6;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI6)
    public String getZrnshrgkmeisai6() {
        return zrnshrgkmeisai6;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai6(String pZrnshrgkmeisai6) {
        zrnshrgkmeisai6 = pZrnshrgkmeisai6;
    }

    private String zrnshrgktuukasyu6;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU6)
    public String getZrnshrgktuukasyu6() {
        return zrnshrgktuukasyu6;
    }

    public void setZrnshrgktuukasyu6(String pZrnshrgktuukasyu6) {
        zrnshrgktuukasyu6 = pZrnshrgktuukasyu6;
    }

    private String zrnbikou6;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU6)
    public String getZrnbikou6() {
        return zrnbikou6;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou6(String pZrnbikou6) {
        zrnbikou6 = pZrnbikou6;
    }

    private String zrntekiyou7;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU7)
    public String getZrntekiyou7() {
        return zrntekiyou7;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou7(String pZrntekiyou7) {
        zrntekiyou7 = pZrntekiyou7;
    }

    private String zrnshrkngkmeisaihugou7;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU7)
    public String getZrnshrkngkmeisaihugou7() {
        return zrnshrkngkmeisaihugou7;
    }

    public void setZrnshrkngkmeisaihugou7(String pZrnshrkngkmeisaihugou7) {
        zrnshrkngkmeisaihugou7 = pZrnshrkngkmeisaihugou7;
    }

    private String zrnshrgkmeisai7;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI7)
    public String getZrnshrgkmeisai7() {
        return zrnshrgkmeisai7;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai7(String pZrnshrgkmeisai7) {
        zrnshrgkmeisai7 = pZrnshrgkmeisai7;
    }

    private String zrnshrgktuukasyu7;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU7)
    public String getZrnshrgktuukasyu7() {
        return zrnshrgktuukasyu7;
    }

    public void setZrnshrgktuukasyu7(String pZrnshrgktuukasyu7) {
        zrnshrgktuukasyu7 = pZrnshrgktuukasyu7;
    }

    private String zrnbikou7;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU7)
    public String getZrnbikou7() {
        return zrnbikou7;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou7(String pZrnbikou7) {
        zrnbikou7 = pZrnbikou7;
    }

    private String zrntekiyou8;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU8)
    public String getZrntekiyou8() {
        return zrntekiyou8;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou8(String pZrntekiyou8) {
        zrntekiyou8 = pZrntekiyou8;
    }

    private String zrnshrkngkmeisaihugou8;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU8)
    public String getZrnshrkngkmeisaihugou8() {
        return zrnshrkngkmeisaihugou8;
    }

    public void setZrnshrkngkmeisaihugou8(String pZrnshrkngkmeisaihugou8) {
        zrnshrkngkmeisaihugou8 = pZrnshrkngkmeisaihugou8;
    }

    private String zrnshrgkmeisai8;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI8)
    public String getZrnshrgkmeisai8() {
        return zrnshrgkmeisai8;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai8(String pZrnshrgkmeisai8) {
        zrnshrgkmeisai8 = pZrnshrgkmeisai8;
    }

    private String zrnshrgktuukasyu8;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU8)
    public String getZrnshrgktuukasyu8() {
        return zrnshrgktuukasyu8;
    }

    public void setZrnshrgktuukasyu8(String pZrnshrgktuukasyu8) {
        zrnshrgktuukasyu8 = pZrnshrgktuukasyu8;
    }

    private String zrnbikou8;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU8)
    public String getZrnbikou8() {
        return zrnbikou8;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou8(String pZrnbikou8) {
        zrnbikou8 = pZrnbikou8;
    }

    private String zrntekiyou9;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU9)
    public String getZrntekiyou9() {
        return zrntekiyou9;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou9(String pZrntekiyou9) {
        zrntekiyou9 = pZrntekiyou9;
    }

    private String zrnshrkngkmeisaihugou9;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU9)
    public String getZrnshrkngkmeisaihugou9() {
        return zrnshrkngkmeisaihugou9;
    }

    public void setZrnshrkngkmeisaihugou9(String pZrnshrkngkmeisaihugou9) {
        zrnshrkngkmeisaihugou9 = pZrnshrkngkmeisaihugou9;
    }

    private String zrnshrgkmeisai9;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI9)
    public String getZrnshrgkmeisai9() {
        return zrnshrgkmeisai9;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai9(String pZrnshrgkmeisai9) {
        zrnshrgkmeisai9 = pZrnshrgkmeisai9;
    }

    private String zrnshrgktuukasyu9;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU9)
    public String getZrnshrgktuukasyu9() {
        return zrnshrgktuukasyu9;
    }

    public void setZrnshrgktuukasyu9(String pZrnshrgktuukasyu9) {
        zrnshrgktuukasyu9 = pZrnshrgktuukasyu9;
    }

    private String zrnbikou9;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU9)
    public String getZrnbikou9() {
        return zrnbikou9;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou9(String pZrnbikou9) {
        zrnbikou9 = pZrnbikou9;
    }

    private String zrntekiyou10;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEKIYOU10)
    public String getZrntekiyou10() {
        return zrntekiyou10;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou10(String pZrntekiyou10) {
        zrntekiyou10 = pZrntekiyou10;
    }

    private String zrnshrkngkmeisaihugou10;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKNGKMEISAIHUGOU10)
    public String getZrnshrkngkmeisaihugou10() {
        return zrnshrkngkmeisaihugou10;
    }

    public void setZrnshrkngkmeisaihugou10(String pZrnshrkngkmeisaihugou10) {
        zrnshrkngkmeisaihugou10 = pZrnshrkngkmeisaihugou10;
    }

    private String zrnshrgkmeisai10;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKMEISAI10)
    public String getZrnshrgkmeisai10() {
        return zrnshrgkmeisai10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai10(String pZrnshrgkmeisai10) {
        zrnshrgkmeisai10 = pZrnshrgkmeisai10;
    }

    private String zrnshrgktuukasyu10;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKTUUKASYU10)
    public String getZrnshrgktuukasyu10() {
        return zrnshrgktuukasyu10;
    }

    public void setZrnshrgktuukasyu10(String pZrnshrgktuukasyu10) {
        zrnshrgktuukasyu10 = pZrnshrgktuukasyu10;
    }

    private String zrnbikou10;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBIKOU10)
    public String getZrnbikou10() {
        return zrnbikou10;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou10(String pZrnbikou10) {
        zrnbikou10 = pZrnbikou10;
    }

    private String zrnshrgkgoukei;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRGKGOUKEI)
    public String getZrnshrgkgoukei() {
        return zrnshrgkgoukei;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkgoukei(String pZrnshrgkgoukei) {
        zrnshrgkgoukei = pZrnshrgkgoukei;
    }

    private String zrnshrtuukasyu;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRTUUKASYU)
    public String getZrnshrtuukasyu() {
        return zrnshrtuukasyu;
    }

    public void setZrnshrtuukasyu(String pZrnshrtuukasyu) {
        zrnshrtuukasyu = pZrnshrtuukasyu;
    }

    private String zrnyobiv215;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV215)
    public String getZrnyobiv215() {
        return zrnyobiv215;
    }

    public void setZrnyobiv215(String pZrnyobiv215) {
        zrnyobiv215 = pZrnyobiv215;
    }

    private String zrnansyuyouyobin10x6;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X6)
    public String getZrnansyuyouyobin10x6() {
        return zrnansyuyouyobin10x6;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x6(String pZrnansyuyouyobin10x6) {
        zrnansyuyouyobin10x6 = pZrnansyuyouyobin10x6;
    }

    private String zrnshrnaiyouhskmongon1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRNAIYOUHSKMONGON1)
    public String getZrnshrnaiyouhskmongon1() {
        return zrnshrnaiyouhskmongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnshrnaiyouhskmongon1(String pZrnshrnaiyouhskmongon1) {
        zrnshrnaiyouhskmongon1 = pZrnshrnaiyouhskmongon1;
    }

    private String zrnshrnaiyouhskmongon2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRNAIYOUHSKMONGON2)
    public String getZrnshrnaiyouhskmongon2() {
        return zrnshrnaiyouhskmongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnshrnaiyouhskmongon2(String pZrnshrnaiyouhskmongon2) {
        zrnshrnaiyouhskmongon2 = pZrnshrnaiyouhskmongon2;
    }

    private String zrnyobiv40;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV40)
    public String getZrnyobiv40() {
        return zrnyobiv40;
    }

    public void setZrnyobiv40(String pZrnyobiv40) {
        zrnyobiv40 = pZrnyobiv40;
    }

    private String zrnansyuyouyobin10x7;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X7)
    public String getZrnansyuyouyobin10x7() {
        return zrnansyuyouyobin10x7;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x7(String pZrnansyuyouyobin10x7) {
        zrnansyuyouyobin10x7 = pZrnansyuyouyobin10x7;
    }

    private String zrnbanknmkj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNBANKNMKJ)
    public String getZrnbanknmkj() {
        return zrnbanknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnbanknmkj(String pZrnbanknmkj) {
        zrnbanknmkj = pZrnbanknmkj;
    }

    private String zrnsitennmkj;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSITENNMKJ)
    public String getZrnsitennmkj() {
        return zrnsitennmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnsitennmkj(String pZrnsitennmkj) {
        zrnsitennmkj = pZrnsitennmkj;
    }

    private String zrnyokinkbn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOKINKBN)
    public String getZrnyokinkbn() {
        return zrnyokinkbn;
    }

    public void setZrnyokinkbn(String pZrnyokinkbn) {
        zrnyokinkbn = pZrnyokinkbn;
    }

    private String zrnkouzano12keta;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNKOUZANO12KETA)
    public String getZrnkouzano12keta() {
        return zrnkouzano12keta;
    }

    public void setZrnkouzano12keta(String pZrnkouzano12keta) {
        zrnkouzano12keta = pZrnkouzano12keta;
    }

    private String zrnkzmeiginmknhan;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNKZMEIGINMKNHAN)
    public String getZrnkzmeiginmknhan() {
        return zrnkzmeiginmknhan;
    }

    public void setZrnkzmeiginmknhan(String pZrnkzmeiginmknhan) {
        zrnkzmeiginmknhan = pZrnkzmeiginmknhan;
    }

    private String zrnkzsyurui;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNKZSYURUI)
    public String getZrnkzsyurui() {
        return zrnkzsyurui;
    }

    public void setZrnkzsyurui(String pZrnkzsyurui) {
        zrnkzsyurui = pZrnkzsyurui;
    }

    private String zrnyobiv26x2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV26X2)
    public String getZrnyobiv26x2() {
        return zrnyobiv26x2;
    }

    public void setZrnyobiv26x2(String pZrnyobiv26x2) {
        zrnyobiv26x2 = pZrnyobiv26x2;
    }

    private String zrnansyuyouyobin10x8;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X8)
    public String getZrnansyuyouyobin10x8() {
        return zrnansyuyouyobin10x8;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x8(String pZrnansyuyouyobin10x8) {
        zrnansyuyouyobin10x8 = pZrnansyuyouyobin10x8;
    }

    private String zrnsynykngk;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSYNYKNGK)
    public String getZrnsynykngk() {
        return zrnsynykngk;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnsynykngk(String pZrnsynykngk) {
        zrnsynykngk = pZrnsynykngk;
    }

    private String zrnsynykngktuukasyu;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSYNYKNGKTUUKASYU)
    public String getZrnsynykngktuukasyu() {
        return zrnsynykngktuukasyu;
    }

    public void setZrnsynykngktuukasyu(String pZrnsynykngktuukasyu) {
        zrnsynykngktuukasyu = pZrnsynykngktuukasyu;
    }

    private String zrnhtykeihi;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNHTYKEIHI)
    public String getZrnhtykeihi() {
        return zrnhtykeihi;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnhtykeihi(String pZrnhtykeihi) {
        zrnhtykeihi = pZrnhtykeihi;
    }

    private String zrnhtykeihituukasyu;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNHTYKEIHITUUKASYU)
    public String getZrnhtykeihituukasyu() {
        return zrnhtykeihituukasyu;
    }

    public void setZrnhtykeihituukasyu(String pZrnhtykeihituukasyu) {
        zrnhtykeihituukasyu = pZrnhtykeihituukasyu;
    }

    private String zrnshrkyksyahtykeihi;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKYKSYAHTYKEIHI)
    public String getZrnshrkyksyahtykeihi() {
        return zrnshrkyksyahtykeihi;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnshrkyksyahtykeihi(String pZrnshrkyksyahtykeihi) {
        zrnshrkyksyahtykeihi = pZrnshrkyksyahtykeihi;
    }

    private String zrnshrkykhtykeihituukasyu;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSHRKYKHTYKEIHITUUKASYU)
    public String getZrnshrkykhtykeihituukasyu() {
        return zrnshrkykhtykeihituukasyu;
    }

    public void setZrnshrkykhtykeihituukasyu(String pZrnshrkykhtykeihituukasyu) {
        zrnshrkykhtykeihituukasyu = pZrnshrkykhtykeihituukasyu;
    }

    private String zrngsbnrkzthtykeihi;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNGSBNRKZTHTYKEIHI)
    public String getZrngsbnrkzthtykeihi() {
        return zrngsbnrkzthtykeihi;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrngsbnrkzthtykeihi(String pZrngsbnrkzthtykeihi) {
        zrngsbnrkzthtykeihi = pZrngsbnrkzthtykeihi;
    }

    private String zrngsbnrkzthtykeihituksyu;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNGSBNRKZTHTYKEIHITUKSYU)
    public String getZrngsbnrkzthtykeihituksyu() {
        return zrngsbnrkzthtykeihituksyu;
    }

    public void setZrngsbnrkzthtykeihituksyu(String pZrngsbnrkzthtykeihituksyu) {
        zrngsbnrkzthtykeihituksyu = pZrngsbnrkzthtykeihituksyu;
    }

    private String zrngsbnrkztsaeki;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNGSBNRKZTSAEKI)
    public String getZrngsbnrkztsaeki() {
        return zrngsbnrkztsaeki;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrngsbnrkztsaeki(String pZrngsbnrkztsaeki) {
        zrngsbnrkztsaeki = pZrngsbnrkztsaeki;
    }

    private String zrngsbnrkztsaekituksyu;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNGSBNRKZTSAEKITUKSYU)
    public String getZrngsbnrkztsaekituksyu() {
        return zrngsbnrkztsaekituksyu;
    }

    public void setZrngsbnrkztsaekituksyu(String pZrngsbnrkztsaekituksyu) {
        zrngsbnrkztsaekituksyu = pZrngsbnrkztsaekituksyu;
    }

    private String zrnzeimunaiyouhensyuctrlkbn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNZEIMUNAIYOUHENSYUCTRLKBN)
    public String getZrnzeimunaiyouhensyuctrlkbn() {
        return zrnzeimunaiyouhensyuctrlkbn;
    }

    public void setZrnzeimunaiyouhensyuctrlkbn(String pZrnzeimunaiyouhensyuctrlkbn) {
        zrnzeimunaiyouhensyuctrlkbn = pZrnzeimunaiyouhensyuctrlkbn;
    }

    private String zrnzeimumongonoutkbn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNZEIMUMONGONOUTKBN)
    public String getZrnzeimumongonoutkbn() {
        return zrnzeimumongonoutkbn;
    }

    public void setZrnzeimumongonoutkbn(String pZrnzeimumongonoutkbn) {
        zrnzeimumongonoutkbn = pZrnzeimumongonoutkbn;
    }

    private String zrnzeimumongon1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNZEIMUMONGON1)
    public String getZrnzeimumongon1() {
        return zrnzeimumongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon1(String pZrnzeimumongon1) {
        zrnzeimumongon1 = pZrnzeimumongon1;
    }

    private String zrnzeimumongon2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNZEIMUMONGON2)
    public String getZrnzeimumongon2() {
        return zrnzeimumongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon2(String pZrnzeimumongon2) {
        zrnzeimumongon2 = pZrnzeimumongon2;
    }

    private String zrnzeimumongon3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNZEIMUMONGON3)
    public String getZrnzeimumongon3() {
        return zrnzeimumongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon3(String pZrnzeimumongon3) {
        zrnzeimumongon3 = pZrnzeimumongon3;
    }

    private String zrnzeimumongon4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNZEIMUMONGON4)
    public String getZrnzeimumongon4() {
        return zrnzeimumongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon4(String pZrnzeimumongon4) {
        zrnzeimumongon4 = pZrnzeimumongon4;
    }

    private String zrnzeimumongon5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNZEIMUMONGON5)
    public String getZrnzeimumongon5() {
        return zrnzeimumongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon5(String pZrnzeimumongon5) {
        zrnzeimumongon5 = pZrnzeimumongon5;
    }

    private String zrnyendthnkzeimuinfohskkbn;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYENDTHNKZEIMUINFOHSKKBN)
    public String getZrnyendthnkzeimuinfohskkbn() {
        return zrnyendthnkzeimuinfohskkbn;
    }

    public void setZrnyendthnkzeimuinfohskkbn(String pZrnyendthnkzeimuinfohskkbn) {
        zrnyendthnkzeimuinfohskkbn = pZrnyendthnkzeimuinfohskkbn;
    }

    private String zrnyobiv74;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV74)
    public String getZrnyobiv74() {
        return zrnyobiv74;
    }

    public void setZrnyobiv74(String pZrnyobiv74) {
        zrnyobiv74 = pZrnyobiv74;
    }

    private String zrnansyuyouyobin10x9;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X9)
    public String getZrnansyuyouyobin10x9() {
        return zrnansyuyouyobin10x9;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x9(String pZrnansyuyouyobin10x9) {
        zrnansyuyouyobin10x9 = pZrnansyuyouyobin10x9;
    }

    private String zrnosirasehyoudai;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEHYOUDAI)
    public String getZrnosirasehyoudai() {
        return zrnosirasehyoudai;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasehyoudai(String pZrnosirasehyoudai) {
        zrnosirasehyoudai = pZrnosirasehyoudai;
    }

    private String zrnosirasemongon1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON1)
    public String getZrnosirasemongon1() {
        return zrnosirasemongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon1(String pZrnosirasemongon1) {
        zrnosirasemongon1 = pZrnosirasemongon1;
    }

    private String zrnosirasemongon2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON2)
    public String getZrnosirasemongon2() {
        return zrnosirasemongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon2(String pZrnosirasemongon2) {
        zrnosirasemongon2 = pZrnosirasemongon2;
    }

    private String zrnosirasemongon3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON3)
    public String getZrnosirasemongon3() {
        return zrnosirasemongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon3(String pZrnosirasemongon3) {
        zrnosirasemongon3 = pZrnosirasemongon3;
    }

    private String zrnosirasemongon4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON4)
    public String getZrnosirasemongon4() {
        return zrnosirasemongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon4(String pZrnosirasemongon4) {
        zrnosirasemongon4 = pZrnosirasemongon4;
    }

    private String zrnosirasemongon5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON5)
    public String getZrnosirasemongon5() {
        return zrnosirasemongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon5(String pZrnosirasemongon5) {
        zrnosirasemongon5 = pZrnosirasemongon5;
    }

    private String zrnosirasemongon6;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON6)
    public String getZrnosirasemongon6() {
        return zrnosirasemongon6;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon6(String pZrnosirasemongon6) {
        zrnosirasemongon6 = pZrnosirasemongon6;
    }

    private String zrnosirasemongon7;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON7)
    public String getZrnosirasemongon7() {
        return zrnosirasemongon7;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon7(String pZrnosirasemongon7) {
        zrnosirasemongon7 = pZrnosirasemongon7;
    }

    private String zrnosirasemongon8;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON8)
    public String getZrnosirasemongon8() {
        return zrnosirasemongon8;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon8(String pZrnosirasemongon8) {
        zrnosirasemongon8 = pZrnosirasemongon8;
    }

    private String zrnosirasemongon9;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON9)
    public String getZrnosirasemongon9() {
        return zrnosirasemongon9;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon9(String pZrnosirasemongon9) {
        zrnosirasemongon9 = pZrnosirasemongon9;
    }

    private String zrnosirasemongon10;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON10)
    public String getZrnosirasemongon10() {
        return zrnosirasemongon10;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon10(String pZrnosirasemongon10) {
        zrnosirasemongon10 = pZrnosirasemongon10;
    }

    private String zrnosirasemongon11;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON11)
    public String getZrnosirasemongon11() {
        return zrnosirasemongon11;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon11(String pZrnosirasemongon11) {
        zrnosirasemongon11 = pZrnosirasemongon11;
    }

    private String zrnosirasemongon12;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON12)
    public String getZrnosirasemongon12() {
        return zrnosirasemongon12;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon12(String pZrnosirasemongon12) {
        zrnosirasemongon12 = pZrnosirasemongon12;
    }

    private String zrnosirasemongon13;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON13)
    public String getZrnosirasemongon13() {
        return zrnosirasemongon13;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon13(String pZrnosirasemongon13) {
        zrnosirasemongon13 = pZrnosirasemongon13;
    }

    private String zrnosirasemongon14;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON14)
    public String getZrnosirasemongon14() {
        return zrnosirasemongon14;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon14(String pZrnosirasemongon14) {
        zrnosirasemongon14 = pZrnosirasemongon14;
    }

    private String zrnosirasemongon15;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON15)
    public String getZrnosirasemongon15() {
        return zrnosirasemongon15;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon15(String pZrnosirasemongon15) {
        zrnosirasemongon15 = pZrnosirasemongon15;
    }

    private String zrnosirasemongon16;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON16)
    public String getZrnosirasemongon16() {
        return zrnosirasemongon16;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon16(String pZrnosirasemongon16) {
        zrnosirasemongon16 = pZrnosirasemongon16;
    }

    private String zrnosirasemongon17;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON17)
    public String getZrnosirasemongon17() {
        return zrnosirasemongon17;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon17(String pZrnosirasemongon17) {
        zrnosirasemongon17 = pZrnosirasemongon17;
    }

    private String zrnosirasemongon18;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON18)
    public String getZrnosirasemongon18() {
        return zrnosirasemongon18;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon18(String pZrnosirasemongon18) {
        zrnosirasemongon18 = pZrnosirasemongon18;
    }

    private String zrnosirasemongon19;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON19)
    public String getZrnosirasemongon19() {
        return zrnosirasemongon19;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon19(String pZrnosirasemongon19) {
        zrnosirasemongon19 = pZrnosirasemongon19;
    }

    private String zrnosirasemongon20;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON20)
    public String getZrnosirasemongon20() {
        return zrnosirasemongon20;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon20(String pZrnosirasemongon20) {
        zrnosirasemongon20 = pZrnosirasemongon20;
    }

    private String zrnosirasemongon21;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON21)
    public String getZrnosirasemongon21() {
        return zrnosirasemongon21;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon21(String pZrnosirasemongon21) {
        zrnosirasemongon21 = pZrnosirasemongon21;
    }

    private String zrnosirasemongon22;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON22)
    public String getZrnosirasemongon22() {
        return zrnosirasemongon22;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon22(String pZrnosirasemongon22) {
        zrnosirasemongon22 = pZrnosirasemongon22;
    }

    private String zrnosirasemongon23;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON23)
    public String getZrnosirasemongon23() {
        return zrnosirasemongon23;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon23(String pZrnosirasemongon23) {
        zrnosirasemongon23 = pZrnosirasemongon23;
    }

    private String zrnosirasemongon24;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON24)
    public String getZrnosirasemongon24() {
        return zrnosirasemongon24;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon24(String pZrnosirasemongon24) {
        zrnosirasemongon24 = pZrnosirasemongon24;
    }

    private String zrnosirasemongon25;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON25)
    public String getZrnosirasemongon25() {
        return zrnosirasemongon25;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon25(String pZrnosirasemongon25) {
        zrnosirasemongon25 = pZrnosirasemongon25;
    }

    private String zrnosirasemongon26;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON26)
    public String getZrnosirasemongon26() {
        return zrnosirasemongon26;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon26(String pZrnosirasemongon26) {
        zrnosirasemongon26 = pZrnosirasemongon26;
    }

    private String zrnosirasemongon27;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON27)
    public String getZrnosirasemongon27() {
        return zrnosirasemongon27;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon27(String pZrnosirasemongon27) {
        zrnosirasemongon27 = pZrnosirasemongon27;
    }

    private String zrnosirasemongon28;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON28)
    public String getZrnosirasemongon28() {
        return zrnosirasemongon28;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon28(String pZrnosirasemongon28) {
        zrnosirasemongon28 = pZrnosirasemongon28;
    }

    private String zrnosirasemongon29;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON29)
    public String getZrnosirasemongon29() {
        return zrnosirasemongon29;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon29(String pZrnosirasemongon29) {
        zrnosirasemongon29 = pZrnosirasemongon29;
    }

    private String zrnosirasemongon30;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON30)
    public String getZrnosirasemongon30() {
        return zrnosirasemongon30;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon30(String pZrnosirasemongon30) {
        zrnosirasemongon30 = pZrnosirasemongon30;
    }

    private String zrnosirasemongon31;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON31)
    public String getZrnosirasemongon31() {
        return zrnosirasemongon31;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon31(String pZrnosirasemongon31) {
        zrnosirasemongon31 = pZrnosirasemongon31;
    }

    private String zrnosirasemongon32;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON32)
    public String getZrnosirasemongon32() {
        return zrnosirasemongon32;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon32(String pZrnosirasemongon32) {
        zrnosirasemongon32 = pZrnosirasemongon32;
    }

    private String zrnosirasemongon33;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON33)
    public String getZrnosirasemongon33() {
        return zrnosirasemongon33;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon33(String pZrnosirasemongon33) {
        zrnosirasemongon33 = pZrnosirasemongon33;
    }

    private String zrnosirasemongon34;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON34)
    public String getZrnosirasemongon34() {
        return zrnosirasemongon34;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon34(String pZrnosirasemongon34) {
        zrnosirasemongon34 = pZrnosirasemongon34;
    }

    private String zrnosirasemongon35;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON35)
    public String getZrnosirasemongon35() {
        return zrnosirasemongon35;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon35(String pZrnosirasemongon35) {
        zrnosirasemongon35 = pZrnosirasemongon35;
    }

    private String zrnosirasemongon36;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON36)
    public String getZrnosirasemongon36() {
        return zrnosirasemongon36;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon36(String pZrnosirasemongon36) {
        zrnosirasemongon36 = pZrnosirasemongon36;
    }

    private String zrnosirasemongon37;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON37)
    public String getZrnosirasemongon37() {
        return zrnosirasemongon37;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon37(String pZrnosirasemongon37) {
        zrnosirasemongon37 = pZrnosirasemongon37;
    }

    private String zrnosirasemongon38;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON38)
    public String getZrnosirasemongon38() {
        return zrnosirasemongon38;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon38(String pZrnosirasemongon38) {
        zrnosirasemongon38 = pZrnosirasemongon38;
    }

    private String zrnosirasemongon39;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON39)
    public String getZrnosirasemongon39() {
        return zrnosirasemongon39;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon39(String pZrnosirasemongon39) {
        zrnosirasemongon39 = pZrnosirasemongon39;
    }

    private String zrnosirasemongon40;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON40)
    public String getZrnosirasemongon40() {
        return zrnosirasemongon40;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon40(String pZrnosirasemongon40) {
        zrnosirasemongon40 = pZrnosirasemongon40;
    }

    private String zrnosirasemongon41;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON41)
    public String getZrnosirasemongon41() {
        return zrnosirasemongon41;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon41(String pZrnosirasemongon41) {
        zrnosirasemongon41 = pZrnosirasemongon41;
    }

    private String zrnosirasemongon42;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON42)
    public String getZrnosirasemongon42() {
        return zrnosirasemongon42;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon42(String pZrnosirasemongon42) {
        zrnosirasemongon42 = pZrnosirasemongon42;
    }

    private String zrnosirasemongon43;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON43)
    public String getZrnosirasemongon43() {
        return zrnosirasemongon43;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon43(String pZrnosirasemongon43) {
        zrnosirasemongon43 = pZrnosirasemongon43;
    }

    private String zrnosirasemongon44;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON44)
    public String getZrnosirasemongon44() {
        return zrnosirasemongon44;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon44(String pZrnosirasemongon44) {
        zrnosirasemongon44 = pZrnosirasemongon44;
    }

    private String zrnosirasemongon45;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON45)
    public String getZrnosirasemongon45() {
        return zrnosirasemongon45;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon45(String pZrnosirasemongon45) {
        zrnosirasemongon45 = pZrnosirasemongon45;
    }

    private String zrnosirasemongon46;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON46)
    public String getZrnosirasemongon46() {
        return zrnosirasemongon46;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46(String pZrnosirasemongon46) {
        zrnosirasemongon46 = pZrnosirasemongon46;
    }

    private String zrnosirasemongon47;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON47)
    public String getZrnosirasemongon47() {
        return zrnosirasemongon47;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon47(String pZrnosirasemongon47) {
        zrnosirasemongon47 = pZrnosirasemongon47;
    }

    private String zrnosirasemongon48;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON48)
    public String getZrnosirasemongon48() {
        return zrnosirasemongon48;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon48(String pZrnosirasemongon48) {
        zrnosirasemongon48 = pZrnosirasemongon48;
    }

    private String zrnosirasemongon49;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON49)
    public String getZrnosirasemongon49() {
        return zrnosirasemongon49;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon49(String pZrnosirasemongon49) {
        zrnosirasemongon49 = pZrnosirasemongon49;
    }

    private String zrnosirasemongon50;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNOSIRASEMONGON50)
    public String getZrnosirasemongon50() {
        return zrnosirasemongon50;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon50(String pZrnosirasemongon50) {
        zrnosirasemongon50 = pZrnosirasemongon50;
    }

    private String zrnyobiv255;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV255)
    public String getZrnyobiv255() {
        return zrnyobiv255;
    }

    public void setZrnyobiv255(String pZrnyobiv255) {
        zrnyobiv255 = pZrnyobiv255;
    }

    private String zrnansyuyouyobin10x10;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X10)
    public String getZrnansyuyouyobin10x10() {
        return zrnansyuyouyobin10x10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x10(String pZrnansyuyouyobin10x10) {
        zrnansyuyouyobin10x10 = pZrnansyuyouyobin10x10;
    }

    private String zrnteisyutusrmongon1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEISYUTUSRMONGON1)
    public String getZrnteisyutusrmongon1() {
        return zrnteisyutusrmongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnteisyutusrmongon1(String pZrnteisyutusrmongon1) {
        zrnteisyutusrmongon1 = pZrnteisyutusrmongon1;
    }

    private String zrnteisyutusrmongon2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEISYUTUSRMONGON2)
    public String getZrnteisyutusrmongon2() {
        return zrnteisyutusrmongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnteisyutusrmongon2(String pZrnteisyutusrmongon2) {
        zrnteisyutusrmongon2 = pZrnteisyutusrmongon2;
    }

    private String zrnteisyutusrmongon3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEISYUTUSRMONGON3)
    public String getZrnteisyutusrmongon3() {
        return zrnteisyutusrmongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnteisyutusrmongon3(String pZrnteisyutusrmongon3) {
        zrnteisyutusrmongon3 = pZrnteisyutusrmongon3;
    }

    private String zrnmsgyobi1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNMSGYOBI1)
    public String getZrnmsgyobi1() {
        return zrnmsgyobi1;
    }

    public void setZrnmsgyobi1(String pZrnmsgyobi1) {
        zrnmsgyobi1 = pZrnmsgyobi1;
    }

    private String zrnansyuyouyobin10x11;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X11)
    public String getZrnansyuyouyobin10x11() {
        return zrnansyuyouyobin10x11;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x11(String pZrnansyuyouyobin10x11) {
        zrnansyuyouyobin10x11 = pZrnansyuyouyobin10x11;
    }

    private String zrnseikyuusyasyomeimongon1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYASYOMEIMONGON1)
    public String getZrnseikyuusyasyomeimongon1() {
        return zrnseikyuusyasyomeimongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyasyomeimongon1(String pZrnseikyuusyasyomeimongon1) {
        zrnseikyuusyasyomeimongon1 = pZrnseikyuusyasyomeimongon1;
    }

    private String zrnseikyuusyasyomeimongon2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYASYOMEIMONGON2)
    public String getZrnseikyuusyasyomeimongon2() {
        return zrnseikyuusyasyomeimongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyasyomeimongon2(String pZrnseikyuusyasyomeimongon2) {
        zrnseikyuusyasyomeimongon2 = pZrnseikyuusyasyomeimongon2;
    }

    private String zrnseikyuusyasyomeimongon3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYASYOMEIMONGON3)
    public String getZrnseikyuusyasyomeimongon3() {
        return zrnseikyuusyasyomeimongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyasyomeimongon3(String pZrnseikyuusyasyomeimongon3) {
        zrnseikyuusyasyomeimongon3 = pZrnseikyuusyasyomeimongon3;
    }

    private String zrnseikyuusyasyomeimongon4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYASYOMEIMONGON4)
    public String getZrnseikyuusyasyomeimongon4() {
        return zrnseikyuusyasyomeimongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyasyomeimongon4(String pZrnseikyuusyasyomeimongon4) {
        zrnseikyuusyasyomeimongon4 = pZrnseikyuusyasyomeimongon4;
    }

    private String zrnseikyuusyasyomeimongon5;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYASYOMEIMONGON5)
    public String getZrnseikyuusyasyomeimongon5() {
        return zrnseikyuusyasyomeimongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyasyomeimongon5(String pZrnseikyuusyasyomeimongon5) {
        zrnseikyuusyasyomeimongon5 = pZrnseikyuusyasyomeimongon5;
    }

    private String zrnseikyuusyasyomeimongon6;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYASYOMEIMONGON6)
    public String getZrnseikyuusyasyomeimongon6() {
        return zrnseikyuusyasyomeimongon6;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyasyomeimongon6(String pZrnseikyuusyasyomeimongon6) {
        zrnseikyuusyasyomeimongon6 = pZrnseikyuusyasyomeimongon6;
    }

    private String zrnseikyuusyasyomeimongon7;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYASYOMEIMONGON7)
    public String getZrnseikyuusyasyomeimongon7() {
        return zrnseikyuusyasyomeimongon7;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyasyomeimongon7(String pZrnseikyuusyasyomeimongon7) {
        zrnseikyuusyasyomeimongon7 = pZrnseikyuusyasyomeimongon7;
    }

    private String zrnseikyuusyasyomeimongon8;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYASYOMEIMONGON8)
    public String getZrnseikyuusyasyomeimongon8() {
        return zrnseikyuusyasyomeimongon8;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyasyomeimongon8(String pZrnseikyuusyasyomeimongon8) {
        zrnseikyuusyasyomeimongon8 = pZrnseikyuusyasyomeimongon8;
    }

    private String zrnseikyuusyasyomeimongon9;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYASYOMEIMONGON9)
    public String getZrnseikyuusyasyomeimongon9() {
        return zrnseikyuusyasyomeimongon9;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyasyomeimongon9(String pZrnseikyuusyasyomeimongon9) {
        zrnseikyuusyasyomeimongon9 = pZrnseikyuusyasyomeimongon9;
    }

    private String zrnseikyuusyagenyno;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYAGENYNO)
    public String getZrnseikyuusyagenyno() {
        return zrnseikyuusyagenyno;
    }

    public void setZrnseikyuusyagenyno(String pZrnseikyuusyagenyno) {
        zrnseikyuusyagenyno = pZrnseikyuusyagenyno;
    }

    private String zrnseikyuusyagenadr1;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYAGENADR1)
    public String getZrnseikyuusyagenadr1() {
        return zrnseikyuusyagenadr1;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyagenadr1(String pZrnseikyuusyagenadr1) {
        zrnseikyuusyagenadr1 = pZrnseikyuusyagenadr1;
    }

    private String zrnseikyuusyagenadr2;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYAGENADR2)
    public String getZrnseikyuusyagenadr2() {
        return zrnseikyuusyagenadr2;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyagenadr2(String pZrnseikyuusyagenadr2) {
        zrnseikyuusyagenadr2 = pZrnseikyuusyagenadr2;
    }

    private String zrnseikyuusyagenadr3;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUSYAGENADR3)
    public String getZrnseikyuusyagenadr3() {
        return zrnseikyuusyagenadr3;
    }

    @DataConvert("toMultiByte")
    public void setZrnseikyuusyagenadr3(String pZrnseikyuusyagenadr3) {
        zrnseikyuusyagenadr3 = pZrnseikyuusyagenadr3;
    }

    private String zrnseikyuuyagentelno;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNSEIKYUUYAGENTELNO)
    public String getZrnseikyuuyagentelno() {
        return zrnseikyuuyagentelno;
    }

    public void setZrnseikyuuyagentelno(String pZrnseikyuuyagentelno) {
        zrnseikyuuyagentelno = pZrnseikyuuyagentelno;
    }

    private String zrntoritugisyasyozokunm;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTORITUGISYASYOZOKUNM)
    public String getZrntoritugisyasyozokunm() {
        return zrntoritugisyasyozokunm;
    }

    @DataConvert("toMultiByte")
    public void setZrntoritugisyasyozokunm(String pZrntoritugisyasyozokunm) {
        zrntoritugisyasyozokunm = pZrntoritugisyasyozokunm;
    }

    private String zrntoritugisyakjncd;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTORITUGISYAKJNCD)
    public String getZrntoritugisyakjncd() {
        return zrntoritugisyakjncd;
    }

    public void setZrntoritugisyakjncd(String pZrntoritugisyakjncd) {
        zrntoritugisyakjncd = pZrntoritugisyakjncd;
    }

    private String zrntoritugisyanm;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTORITUGISYANM)
    public String getZrntoritugisyanm() {
        return zrntoritugisyanm;
    }

    @DataConvert("toMultiByte")
    public void setZrntoritugisyanm(String pZrntoritugisyanm) {
        zrntoritugisyanm = pZrntoritugisyanm;
    }

    private String zrnhozonkkny;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNHOZONKKNY)
    public String getZrnhozonkkny() {
        return zrnhozonkkny;
    }

    public void setZrnhozonkkny(String pZrnhozonkkny) {
        zrnhozonkkny = pZrnhozonkkny;
    }

    private String zrnyobiv168;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV168)
    public String getZrnyobiv168() {
        return zrnyobiv168;
    }

    public void setZrnyobiv168(String pZrnyobiv168) {
        zrnyobiv168 = pZrnyobiv168;
    }

    private String zrnansyuyouyobin10x12;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNANSYUYOUYOBIN10X12)
    public String getZrnansyuyouyobin10x12() {
        return zrnansyuyouyobin10x12;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnansyuyouyobin10x12(String pZrnansyuyouyobin10x12) {
        zrnansyuyouyobin10x12 = pZrnansyuyouyobin10x12;
    }

    private String zrnteisyutusrmongon4;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNTEISYUTUSRMONGON4)
    public String getZrnteisyutusrmongon4() {
        return zrnteisyutusrmongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnteisyutusrmongon4(String pZrnteisyutusrmongon4) {
        zrnteisyutusrmongon4 = pZrnteisyutusrmongon4;
    }

    private String zrnyobiv155;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV155)
    public String getZrnyobiv155() {
        return zrnyobiv155;
    }

    public void setZrnyobiv155(String pZrnyobiv155) {
        zrnyobiv155 = pZrnyobiv155;
    }

    private String zrnyobiv97;

    @Column(name=GenZT_SyoumetuTuutiRn.ZRNYOBIV97)
    public String getZrnyobiv97() {
        return zrnyobiv97;
    }

    public void setZrnyobiv97(String pZrnyobiv97) {
        zrnyobiv97 = pZrnyobiv97;
    }
}