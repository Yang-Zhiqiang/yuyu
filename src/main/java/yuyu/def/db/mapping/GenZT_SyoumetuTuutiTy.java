package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.ZT_SyoumetuTuutiTy;
import yuyu.def.db.id.PKZT_SyoumetuTuutiTy;
import yuyu.def.db.meta.GenQZT_SyoumetuTuutiTy;
import yuyu.def.db.meta.QZT_SyoumetuTuutiTy;

/**
 * 消滅通知Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SyoumetuTuutiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoumetuTuutiTy}</td><td colspan="3">消滅通知Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_SyoumetuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdkj ztytyouhyouymdkj}</td><td>（中継用）帳票作成日（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SyoumetuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantousitukbn ztytantousitukbn}</td><td>（中継用）担当室区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysksdoufuukbn ztysksdoufuukbn}</td><td>（中継用）請求書同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymynosinkokuiraidoufuukbn ztymynosinkokuiraidoufuukbn}</td><td>（中継用）マイナンバー申告依頼同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">{@link PKZT_SyoumetuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratemongonumukbn ztykwsratemongonumukbn}</td><td>（中継用）為替レート文言有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv13 ztyyobiv13}</td><td>（中継用）予備項目Ｖ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10 ztyansyuyouyobin10}</td><td>（中継用）案内収納用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskyno ztyshskyno}</td><td>（中継用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr1kj ztyshskadr1kj}</td><td>（中継用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr2kj ztyshskadr2kj}</td><td>（中継用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr3kj ztyshskadr3kj}</td><td>（中継用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkj ztyshsnmkj}</td><td>（中継用）送付先名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv44 ztyyobiv44}</td><td>（中継用）予備項目Ｖ４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x2 ztyansyuyouyobin10x2}</td><td>（中継用）案内収納用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawyno ztytawyno}</td><td>（中継用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr1kj ztytawadr1kj}</td><td>（中継用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr2kj ztytawadr2kj}</td><td>（中継用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr3kj ztytawadr3kj}</td><td>（中継用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoiawasekaisyanmkj ztytoiawasekaisyanmkj}</td><td>（中継用）問合せ先会社名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawsosikikj ztytawsosikikj}</td><td>（中継用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawtelnov14 ztytawtelnov14}</td><td>（中継用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou1x18keta ztytawteluktkkanou1x18keta}</td><td>（中継用）問合せ先電話受付可能時間１（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou2x18keta ztytawteluktkkanou2x18keta}</td><td>（中継用）問合せ先電話受付可能時間２（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv50 ztyyobiv50}</td><td>（中継用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x3 ztyansyuyouyobin10x3}</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon50keta1 ztyaisatumongon50keta1}</td><td>（中継用）挨拶文言（５０桁）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon50keta2 ztyaisatumongon50keta2}</td><td>（中継用）挨拶文言（５０桁）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon50keta3 ztyaisatumongon50keta3}</td><td>（中継用）挨拶文言（５０桁）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon50keta4 ztyaisatumongon50keta4}</td><td>（中継用）挨拶文言（５０桁）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon50keta5 ztyaisatumongon50keta5}</td><td>（中継用）挨拶文言（５０桁）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumongon50keta6 ztyaisatumongon50keta6}</td><td>（中継用）挨拶文言（５０桁）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv120 ztyyobiv120}</td><td>（中継用）予備項目Ｖ１２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x4 ztyansyuyouyobin10x4}</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymdseireki ztykykymdseireki}</td><td>（中継用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyurui30keta ztyhknsyurui30keta}</td><td>（中継用）保険種類（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetuymd ztysyoumetuymd}</td><td>（中継用）消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyoharaimodosikn ztyoharaimodosikn}</td><td>（中継用）お払戻金</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x5 ztyansyuyouyobin10x5}</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrymd11keta ztyshrymd11keta}</td><td>（中継用）支払日（１１桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou1 ztytekiyou1}</td><td>（中継用）摘要１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou1 ztyshrkngkmeisaihugou1}</td><td>（中継用）支払金額明細符号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai1 ztyshrgkmeisai1}</td><td>（中継用）支払金額明細１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu1 ztyshrgktuukasyu1}</td><td>（中継用）支払金額通貨種類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou1 ztybikou1}</td><td>（中継用）備考１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou2 ztytekiyou2}</td><td>（中継用）摘要２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou2 ztyshrkngkmeisaihugou2}</td><td>（中継用）支払金額明細符号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai2 ztyshrgkmeisai2}</td><td>（中継用）支払金額明細２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu2 ztyshrgktuukasyu2}</td><td>（中継用）支払金額通貨種類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou2 ztybikou2}</td><td>（中継用）備考２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou3 ztytekiyou3}</td><td>（中継用）摘要３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou3 ztyshrkngkmeisaihugou3}</td><td>（中継用）支払金額明細符号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai3 ztyshrgkmeisai3}</td><td>（中継用）支払金額明細３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu3 ztyshrgktuukasyu3}</td><td>（中継用）支払金額通貨種類３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou3 ztybikou3}</td><td>（中継用）備考３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou4 ztytekiyou4}</td><td>（中継用）摘要４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou4 ztyshrkngkmeisaihugou4}</td><td>（中継用）支払金額明細符号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai4 ztyshrgkmeisai4}</td><td>（中継用）支払金額明細４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu4 ztyshrgktuukasyu4}</td><td>（中継用）支払金額通貨種類４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou4 ztybikou4}</td><td>（中継用）備考４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou5 ztytekiyou5}</td><td>（中継用）摘要５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou5 ztyshrkngkmeisaihugou5}</td><td>（中継用）支払金額明細符号５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai5 ztyshrgkmeisai5}</td><td>（中継用）支払金額明細５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu5 ztyshrgktuukasyu5}</td><td>（中継用）支払金額通貨種類５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou5 ztybikou5}</td><td>（中継用）備考５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou6 ztytekiyou6}</td><td>（中継用）摘要６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou6 ztyshrkngkmeisaihugou6}</td><td>（中継用）支払金額明細符号６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai6 ztyshrgkmeisai6}</td><td>（中継用）支払金額明細６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu6 ztyshrgktuukasyu6}</td><td>（中継用）支払金額通貨種類６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou6 ztybikou6}</td><td>（中継用）備考６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou7 ztytekiyou7}</td><td>（中継用）摘要７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou7 ztyshrkngkmeisaihugou7}</td><td>（中継用）支払金額明細符号７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai7 ztyshrgkmeisai7}</td><td>（中継用）支払金額明細７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu7 ztyshrgktuukasyu7}</td><td>（中継用）支払金額通貨種類７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou7 ztybikou7}</td><td>（中継用）備考７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou8 ztytekiyou8}</td><td>（中継用）摘要８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou8 ztyshrkngkmeisaihugou8}</td><td>（中継用）支払金額明細符号８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai8 ztyshrgkmeisai8}</td><td>（中継用）支払金額明細８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu8 ztyshrgktuukasyu8}</td><td>（中継用）支払金額通貨種類８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou8 ztybikou8}</td><td>（中継用）備考８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou9 ztytekiyou9}</td><td>（中継用）摘要９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou9 ztyshrkngkmeisaihugou9}</td><td>（中継用）支払金額明細符号９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai9 ztyshrgkmeisai9}</td><td>（中継用）支払金額明細９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu9 ztyshrgktuukasyu9}</td><td>（中継用）支払金額通貨種類９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou9 ztybikou9}</td><td>（中継用）備考９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou10 ztytekiyou10}</td><td>（中継用）摘要１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou10 ztyshrkngkmeisaihugou10}</td><td>（中継用）支払金額明細符号１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai10 ztyshrgkmeisai10}</td><td>（中継用）支払金額明細１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu10 ztyshrgktuukasyu10}</td><td>（中継用）支払金額通貨種類１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou10 ztybikou10}</td><td>（中継用）備考１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkgoukei ztyshrgkgoukei}</td><td>（中継用）支払額合計</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtuukasyu ztyshrtuukasyu}</td><td>（中継用）支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv215 ztyyobiv215}</td><td>（中継用）予備項目Ｖ２１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x6 ztyansyuyouyobin10x6}</td><td>（中継用）案内収納用予備項目Ｎ１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrnaiyouhskmongon1 ztyshrnaiyouhskmongon1}</td><td>（中継用）支払内容補足文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrnaiyouhskmongon2 ztyshrnaiyouhskmongon2}</td><td>（中継用）支払内容補足文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv40 ztyyobiv40}</td><td>（中継用）予備項目Ｖ４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x7 ztyansyuyouyobin10x7}</td><td>（中継用）案内収納用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybanknmkj ztybanknmkj}</td><td>（中継用）銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysitennmkj ztysitennmkj}</td><td>（中継用）支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyokinkbn ztyyokinkbn}</td><td>（中継用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzano12keta ztykouzano12keta}</td><td>（中継用）口座番号（１２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzmeiginmknhan ztykzmeiginmknhan}</td><td>（中継用）口座名義人氏名（カナ）（半角）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzsyurui ztykzsyurui}</td><td>（中継用）口座種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv26x2 ztyyobiv26x2}</td><td>（中継用）予備項目Ｖ２６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x8 ztyansyuyouyobin10x8}</td><td>（中継用）案内収納用予備項目Ｎ１０＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysynykngk ztysynykngk}</td><td>（中継用）収入金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysynykngktuukasyu ztysynykngktuukasyu}</td><td>（中継用）収入金額通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtykeihi ztyhtykeihi}</td><td>（中継用）必要経費</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtykeihituukasyu ztyhtykeihituukasyu}</td><td>（中継用）必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkyksyahtykeihi ztyshrkyksyahtykeihi}</td><td>（中継用）お支払時の契約者の必要経費</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkykhtykeihituukasyu ztyshrkykhtykeihituukasyu}</td><td>（中継用）お支払時の契約者の必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygsbnrkzthtykeihi ztygsbnrkzthtykeihi}</td><td>（中継用）源泉分離課税対象の必要経費</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygsbnrkzthtykeihituksyu ztygsbnrkzthtykeihituksyu}</td><td>（中継用）源泉分離課税対象の必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygsbnrkztsaeki ztygsbnrkztsaeki}</td><td>（中継用）源泉分離課税対象の差益</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygsbnrkztsaekituksyu ztygsbnrkztsaekituksyu}</td><td>（中継用）源泉分離課税対象の差益通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimunaiyouhensyuctrlkbn ztyzeimunaiyouhensyuctrlkbn}</td><td>（中継用）税務内容編集制御区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongonoutkbn ztyzeimumongonoutkbn}</td><td>（中継用）税務文言出力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon1 ztyzeimumongon1}</td><td>（中継用）税務文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon2 ztyzeimumongon2}</td><td>（中継用）税務文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon3 ztyzeimumongon3}</td><td>（中継用）税務文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon4 ztyzeimumongon4}</td><td>（中継用）税務文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon5 ztyzeimumongon5}</td><td>（中継用）税務文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyendthnkzeimuinfohskkbn ztyyendthnkzeimuinfohskkbn}</td><td>（中継用）円建変更時税務情報補足区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv74 ztyyobiv74}</td><td>（中継用）予備項目Ｖ７４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x9 ztyansyuyouyobin10x9}</td><td>（中継用）案内収納用予備項目Ｎ１０＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasehyoudai ztyosirasehyoudai}</td><td>（中継用）お知らせ表題</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon1 ztyosirasemongon1}</td><td>（中継用）お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon2 ztyosirasemongon2}</td><td>（中継用）お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon3 ztyosirasemongon3}</td><td>（中継用）お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon4 ztyosirasemongon4}</td><td>（中継用）お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon5 ztyosirasemongon5}</td><td>（中継用）お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon6 ztyosirasemongon6}</td><td>（中継用）お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon7 ztyosirasemongon7}</td><td>（中継用）お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon8 ztyosirasemongon8}</td><td>（中継用）お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon9 ztyosirasemongon9}</td><td>（中継用）お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon10 ztyosirasemongon10}</td><td>（中継用）お知らせ文言１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon11 ztyosirasemongon11}</td><td>（中継用）お知らせ文言１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon12 ztyosirasemongon12}</td><td>（中継用）お知らせ文言１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon13 ztyosirasemongon13}</td><td>（中継用）お知らせ文言１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon14 ztyosirasemongon14}</td><td>（中継用）お知らせ文言１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon15 ztyosirasemongon15}</td><td>（中継用）お知らせ文言１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon16 ztyosirasemongon16}</td><td>（中継用）お知らせ文言１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon17 ztyosirasemongon17}</td><td>（中継用）お知らせ文言１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon18 ztyosirasemongon18}</td><td>（中継用）お知らせ文言１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon19 ztyosirasemongon19}</td><td>（中継用）お知らせ文言１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon20 ztyosirasemongon20}</td><td>（中継用）お知らせ文言２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon21 ztyosirasemongon21}</td><td>（中継用）お知らせ文言２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon22 ztyosirasemongon22}</td><td>（中継用）お知らせ文言２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon23 ztyosirasemongon23}</td><td>（中継用）お知らせ文言２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon24 ztyosirasemongon24}</td><td>（中継用）お知らせ文言２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon25 ztyosirasemongon25}</td><td>（中継用）お知らせ文言２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon26 ztyosirasemongon26}</td><td>（中継用）お知らせ文言２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon27 ztyosirasemongon27}</td><td>（中継用）お知らせ文言２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon28 ztyosirasemongon28}</td><td>（中継用）お知らせ文言２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon29 ztyosirasemongon29}</td><td>（中継用）お知らせ文言２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon30 ztyosirasemongon30}</td><td>（中継用）お知らせ文言３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon31 ztyosirasemongon31}</td><td>（中継用）お知らせ文言３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon32 ztyosirasemongon32}</td><td>（中継用）お知らせ文言３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon33 ztyosirasemongon33}</td><td>（中継用）お知らせ文言３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon34 ztyosirasemongon34}</td><td>（中継用）お知らせ文言３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon35 ztyosirasemongon35}</td><td>（中継用）お知らせ文言３５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon36 ztyosirasemongon36}</td><td>（中継用）お知らせ文言３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon37 ztyosirasemongon37}</td><td>（中継用）お知らせ文言３７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon38 ztyosirasemongon38}</td><td>（中継用）お知らせ文言３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon39 ztyosirasemongon39}</td><td>（中継用）お知らせ文言３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon40 ztyosirasemongon40}</td><td>（中継用）お知らせ文言４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon41 ztyosirasemongon41}</td><td>（中継用）お知らせ文言４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon42 ztyosirasemongon42}</td><td>（中継用）お知らせ文言４２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon43 ztyosirasemongon43}</td><td>（中継用）お知らせ文言４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon44 ztyosirasemongon44}</td><td>（中継用）お知らせ文言４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon45 ztyosirasemongon45}</td><td>（中継用）お知らせ文言４５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46 ztyosirasemongon46}</td><td>（中継用）お知らせ文言４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon47 ztyosirasemongon47}</td><td>（中継用）お知らせ文言４７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon48 ztyosirasemongon48}</td><td>（中継用）お知らせ文言４８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon49 ztyosirasemongon49}</td><td>（中継用）お知らせ文言４９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon50 ztyosirasemongon50}</td><td>（中継用）お知らせ文言５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv255 ztyyobiv255}</td><td>（中継用）予備項目Ｖ２５５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x10 ztyansyuyouyobin10x10}</td><td>（中継用）案内収納用予備項目Ｎ１０＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteisyutusrmongon1 ztyteisyutusrmongon1}</td><td>（中継用）ご提出いただく書類文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteisyutusrmongon2 ztyteisyutusrmongon2}</td><td>（中継用）ご提出いただく書類文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteisyutusrmongon3 ztyteisyutusrmongon3}</td><td>（中継用）ご提出いただく書類文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymsgyobi1 ztymsgyobi1}</td><td>（中継用）メッセージ予備項目１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x11 ztyansyuyouyobin10x11}</td><td>（中継用）案内収納用予備項目Ｎ１０＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyasyomeimongon1 ztyseikyuusyasyomeimongon1}</td><td>（中継用）請求者署名欄文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyasyomeimongon2 ztyseikyuusyasyomeimongon2}</td><td>（中継用）請求者署名欄文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyasyomeimongon3 ztyseikyuusyasyomeimongon3}</td><td>（中継用）請求者署名欄文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyasyomeimongon4 ztyseikyuusyasyomeimongon4}</td><td>（中継用）請求者署名欄文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyasyomeimongon5 ztyseikyuusyasyomeimongon5}</td><td>（中継用）請求者署名欄文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyasyomeimongon6 ztyseikyuusyasyomeimongon6}</td><td>（中継用）請求者署名欄文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyasyomeimongon7 ztyseikyuusyasyomeimongon7}</td><td>（中継用）請求者署名欄文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyasyomeimongon8 ztyseikyuusyasyomeimongon8}</td><td>（中継用）請求者署名欄文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyasyomeimongon9 ztyseikyuusyasyomeimongon9}</td><td>（中継用）請求者署名欄文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyagenyno ztyseikyuusyagenyno}</td><td>（中継用）請求者現住所郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyagenadr1 ztyseikyuusyagenadr1}</td><td>（中継用）請求者現住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyagenadr2 ztyseikyuusyagenadr2}</td><td>（中継用）請求者現住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuusyagenadr3 ztyseikyuusyagenadr3}</td><td>（中継用）請求者現住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikyuuyagentelno ztyseikyuuyagentelno}</td><td>（中継用）請求者現住所電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoritugisyasyozokunm ztytoritugisyasyozokunm}</td><td>（中継用）取次者所属名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoritugisyakjncd ztytoritugisyakjncd}</td><td>（中継用）取次者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoritugisyanm ztytoritugisyanm}</td><td>（中継用）取次者氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhozonkkny ztyhozonkkny}</td><td>（中継用）保存期間（年）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv168 ztyyobiv168}</td><td>（中継用）予備項目Ｖ１６８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyansyuyouyobin10x12 ztyansyuyouyobin10x12}</td><td>（中継用）案内収納用予備項目Ｎ１０＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteisyutusrmongon4 ztyteisyutusrmongon4}</td><td>（中継用）ご提出いただく書類文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv155 ztyyobiv155}</td><td>（中継用）予備項目Ｖ１５５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv97 ztyyobiv97}</td><td>（中継用）予備項目Ｖ９７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoumetuTuutiTy
 * @see     PKZT_SyoumetuTuutiTy
 * @see     QZT_SyoumetuTuutiTy
 * @see     GenQZT_SyoumetuTuutiTy
 */
@MappedSuperclass
@Table(name=GenZT_SyoumetuTuutiTy.TABLE_NAME)
@IdClass(value=PKZT_SyoumetuTuutiTy.class)
public abstract class GenZT_SyoumetuTuutiTy extends AbstractExDBEntity<ZT_SyoumetuTuutiTy, PKZT_SyoumetuTuutiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyoumetuTuutiTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYTYOUHYOUYMDKJ         = "ztytyouhyouymdkj";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYTANTOUSITUKBN         = "ztytantousitukbn";
    public static final String ZTYSKSDOUFUUKBN          = "ztysksdoufuukbn";
    public static final String ZTYMYNOSINKOKUIRAIDOUFUUKBN = "ztymynosinkokuiraidoufuukbn";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYKWSRATEMONGONUMUKBN   = "ztykwsratemongonumukbn";
    public static final String ZTYYOBIV13               = "ztyyobiv13";
    public static final String ZTYANSYUYOUYOBIN10       = "ztyansyuyouyobin10";
    public static final String ZTYSHSKYNO               = "ztyshskyno";
    public static final String ZTYSHSKADR1KJ            = "ztyshskadr1kj";
    public static final String ZTYSHSKADR2KJ            = "ztyshskadr2kj";
    public static final String ZTYSHSKADR3KJ            = "ztyshskadr3kj";
    public static final String ZTYSHSNMKJ               = "ztyshsnmkj";
    public static final String ZTYYOBIV44               = "ztyyobiv44";
    public static final String ZTYANSYUYOUYOBIN10X2     = "ztyansyuyouyobin10x2";
    public static final String ZTYTAWYNO                = "ztytawyno";
    public static final String ZTYTAWADR1KJ             = "ztytawadr1kj";
    public static final String ZTYTAWADR2KJ             = "ztytawadr2kj";
    public static final String ZTYTAWADR3KJ             = "ztytawadr3kj";
    public static final String ZTYTOIAWASEKAISYANMKJ    = "ztytoiawasekaisyanmkj";
    public static final String ZTYTAWSOSIKIKJ           = "ztytawsosikikj";
    public static final String ZTYTAWTELNOV14           = "ztytawtelnov14";
    public static final String ZTYTAWTELUKTKKANOU1X18KETA = "ztytawteluktkkanou1x18keta";
    public static final String ZTYTAWTELUKTKKANOU2X18KETA = "ztytawteluktkkanou2x18keta";
    public static final String ZTYYOBIV50               = "ztyyobiv50";
    public static final String ZTYANSYUYOUYOBIN10X3     = "ztyansyuyouyobin10x3";
    public static final String ZTYAISATUMONGON50KETA1   = "ztyaisatumongon50keta1";
    public static final String ZTYAISATUMONGON50KETA2   = "ztyaisatumongon50keta2";
    public static final String ZTYAISATUMONGON50KETA3   = "ztyaisatumongon50keta3";
    public static final String ZTYAISATUMONGON50KETA4   = "ztyaisatumongon50keta4";
    public static final String ZTYAISATUMONGON50KETA5   = "ztyaisatumongon50keta5";
    public static final String ZTYAISATUMONGON50KETA6   = "ztyaisatumongon50keta6";
    public static final String ZTYYOBIV120              = "ztyyobiv120";
    public static final String ZTYANSYUYOUYOBIN10X4     = "ztyansyuyouyobin10x4";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYKYKYMDSEIREKI         = "ztykykymdseireki";
    public static final String ZTYHKNSYURUI30KETA       = "ztyhknsyurui30keta";
    public static final String ZTYSYOUMETUYMD           = "ztysyoumetuymd";
    public static final String ZTYOHARAIMODOSIKN        = "ztyoharaimodosikn";
    public static final String ZTYYOBIV20               = "ztyyobiv20";
    public static final String ZTYANSYUYOUYOBIN10X5     = "ztyansyuyouyobin10x5";
    public static final String ZTYSHRYMD11KETA          = "ztyshrymd11keta";
    public static final String ZTYTEKIYOU1              = "ztytekiyou1";
    public static final String ZTYSHRKNGKMEISAIHUGOU1   = "ztyshrkngkmeisaihugou1";
    public static final String ZTYSHRGKMEISAI1          = "ztyshrgkmeisai1";
    public static final String ZTYSHRGKTUUKASYU1        = "ztyshrgktuukasyu1";
    public static final String ZTYBIKOU1                = "ztybikou1";
    public static final String ZTYTEKIYOU2              = "ztytekiyou2";
    public static final String ZTYSHRKNGKMEISAIHUGOU2   = "ztyshrkngkmeisaihugou2";
    public static final String ZTYSHRGKMEISAI2          = "ztyshrgkmeisai2";
    public static final String ZTYSHRGKTUUKASYU2        = "ztyshrgktuukasyu2";
    public static final String ZTYBIKOU2                = "ztybikou2";
    public static final String ZTYTEKIYOU3              = "ztytekiyou3";
    public static final String ZTYSHRKNGKMEISAIHUGOU3   = "ztyshrkngkmeisaihugou3";
    public static final String ZTYSHRGKMEISAI3          = "ztyshrgkmeisai3";
    public static final String ZTYSHRGKTUUKASYU3        = "ztyshrgktuukasyu3";
    public static final String ZTYBIKOU3                = "ztybikou3";
    public static final String ZTYTEKIYOU4              = "ztytekiyou4";
    public static final String ZTYSHRKNGKMEISAIHUGOU4   = "ztyshrkngkmeisaihugou4";
    public static final String ZTYSHRGKMEISAI4          = "ztyshrgkmeisai4";
    public static final String ZTYSHRGKTUUKASYU4        = "ztyshrgktuukasyu4";
    public static final String ZTYBIKOU4                = "ztybikou4";
    public static final String ZTYTEKIYOU5              = "ztytekiyou5";
    public static final String ZTYSHRKNGKMEISAIHUGOU5   = "ztyshrkngkmeisaihugou5";
    public static final String ZTYSHRGKMEISAI5          = "ztyshrgkmeisai5";
    public static final String ZTYSHRGKTUUKASYU5        = "ztyshrgktuukasyu5";
    public static final String ZTYBIKOU5                = "ztybikou5";
    public static final String ZTYTEKIYOU6              = "ztytekiyou6";
    public static final String ZTYSHRKNGKMEISAIHUGOU6   = "ztyshrkngkmeisaihugou6";
    public static final String ZTYSHRGKMEISAI6          = "ztyshrgkmeisai6";
    public static final String ZTYSHRGKTUUKASYU6        = "ztyshrgktuukasyu6";
    public static final String ZTYBIKOU6                = "ztybikou6";
    public static final String ZTYTEKIYOU7              = "ztytekiyou7";
    public static final String ZTYSHRKNGKMEISAIHUGOU7   = "ztyshrkngkmeisaihugou7";
    public static final String ZTYSHRGKMEISAI7          = "ztyshrgkmeisai7";
    public static final String ZTYSHRGKTUUKASYU7        = "ztyshrgktuukasyu7";
    public static final String ZTYBIKOU7                = "ztybikou7";
    public static final String ZTYTEKIYOU8              = "ztytekiyou8";
    public static final String ZTYSHRKNGKMEISAIHUGOU8   = "ztyshrkngkmeisaihugou8";
    public static final String ZTYSHRGKMEISAI8          = "ztyshrgkmeisai8";
    public static final String ZTYSHRGKTUUKASYU8        = "ztyshrgktuukasyu8";
    public static final String ZTYBIKOU8                = "ztybikou8";
    public static final String ZTYTEKIYOU9              = "ztytekiyou9";
    public static final String ZTYSHRKNGKMEISAIHUGOU9   = "ztyshrkngkmeisaihugou9";
    public static final String ZTYSHRGKMEISAI9          = "ztyshrgkmeisai9";
    public static final String ZTYSHRGKTUUKASYU9        = "ztyshrgktuukasyu9";
    public static final String ZTYBIKOU9                = "ztybikou9";
    public static final String ZTYTEKIYOU10             = "ztytekiyou10";
    public static final String ZTYSHRKNGKMEISAIHUGOU10  = "ztyshrkngkmeisaihugou10";
    public static final String ZTYSHRGKMEISAI10         = "ztyshrgkmeisai10";
    public static final String ZTYSHRGKTUUKASYU10       = "ztyshrgktuukasyu10";
    public static final String ZTYBIKOU10               = "ztybikou10";
    public static final String ZTYSHRGKGOUKEI           = "ztyshrgkgoukei";
    public static final String ZTYSHRTUUKASYU           = "ztyshrtuukasyu";
    public static final String ZTYYOBIV215              = "ztyyobiv215";
    public static final String ZTYANSYUYOUYOBIN10X6     = "ztyansyuyouyobin10x6";
    public static final String ZTYSHRNAIYOUHSKMONGON1   = "ztyshrnaiyouhskmongon1";
    public static final String ZTYSHRNAIYOUHSKMONGON2   = "ztyshrnaiyouhskmongon2";
    public static final String ZTYYOBIV40               = "ztyyobiv40";
    public static final String ZTYANSYUYOUYOBIN10X7     = "ztyansyuyouyobin10x7";
    public static final String ZTYBANKNMKJ              = "ztybanknmkj";
    public static final String ZTYSITENNMKJ             = "ztysitennmkj";
    public static final String ZTYYOKINKBN              = "ztyyokinkbn";
    public static final String ZTYKOUZANO12KETA         = "ztykouzano12keta";
    public static final String ZTYKZMEIGINMKNHAN        = "ztykzmeiginmknhan";
    public static final String ZTYKZSYURUI              = "ztykzsyurui";
    public static final String ZTYYOBIV26X2             = "ztyyobiv26x2";
    public static final String ZTYANSYUYOUYOBIN10X8     = "ztyansyuyouyobin10x8";
    public static final String ZTYSYNYKNGK              = "ztysynykngk";
    public static final String ZTYSYNYKNGKTUUKASYU      = "ztysynykngktuukasyu";
    public static final String ZTYHTYKEIHI              = "ztyhtykeihi";
    public static final String ZTYHTYKEIHITUUKASYU      = "ztyhtykeihituukasyu";
    public static final String ZTYSHRKYKSYAHTYKEIHI     = "ztyshrkyksyahtykeihi";
    public static final String ZTYSHRKYKHTYKEIHITUUKASYU = "ztyshrkykhtykeihituukasyu";
    public static final String ZTYGSBNRKZTHTYKEIHI      = "ztygsbnrkzthtykeihi";
    public static final String ZTYGSBNRKZTHTYKEIHITUKSYU = "ztygsbnrkzthtykeihituksyu";
    public static final String ZTYGSBNRKZTSAEKI         = "ztygsbnrkztsaeki";
    public static final String ZTYGSBNRKZTSAEKITUKSYU   = "ztygsbnrkztsaekituksyu";
    public static final String ZTYZEIMUNAIYOUHENSYUCTRLKBN = "ztyzeimunaiyouhensyuctrlkbn";
    public static final String ZTYZEIMUMONGONOUTKBN     = "ztyzeimumongonoutkbn";
    public static final String ZTYZEIMUMONGON1          = "ztyzeimumongon1";
    public static final String ZTYZEIMUMONGON2          = "ztyzeimumongon2";
    public static final String ZTYZEIMUMONGON3          = "ztyzeimumongon3";
    public static final String ZTYZEIMUMONGON4          = "ztyzeimumongon4";
    public static final String ZTYZEIMUMONGON5          = "ztyzeimumongon5";
    public static final String ZTYYENDTHNKZEIMUINFOHSKKBN = "ztyyendthnkzeimuinfohskkbn";
    public static final String ZTYYOBIV74               = "ztyyobiv74";
    public static final String ZTYANSYUYOUYOBIN10X9     = "ztyansyuyouyobin10x9";
    public static final String ZTYOSIRASEHYOUDAI        = "ztyosirasehyoudai";
    public static final String ZTYOSIRASEMONGON1        = "ztyosirasemongon1";
    public static final String ZTYOSIRASEMONGON2        = "ztyosirasemongon2";
    public static final String ZTYOSIRASEMONGON3        = "ztyosirasemongon3";
    public static final String ZTYOSIRASEMONGON4        = "ztyosirasemongon4";
    public static final String ZTYOSIRASEMONGON5        = "ztyosirasemongon5";
    public static final String ZTYOSIRASEMONGON6        = "ztyosirasemongon6";
    public static final String ZTYOSIRASEMONGON7        = "ztyosirasemongon7";
    public static final String ZTYOSIRASEMONGON8        = "ztyosirasemongon8";
    public static final String ZTYOSIRASEMONGON9        = "ztyosirasemongon9";
    public static final String ZTYOSIRASEMONGON10       = "ztyosirasemongon10";
    public static final String ZTYOSIRASEMONGON11       = "ztyosirasemongon11";
    public static final String ZTYOSIRASEMONGON12       = "ztyosirasemongon12";
    public static final String ZTYOSIRASEMONGON13       = "ztyosirasemongon13";
    public static final String ZTYOSIRASEMONGON14       = "ztyosirasemongon14";
    public static final String ZTYOSIRASEMONGON15       = "ztyosirasemongon15";
    public static final String ZTYOSIRASEMONGON16       = "ztyosirasemongon16";
    public static final String ZTYOSIRASEMONGON17       = "ztyosirasemongon17";
    public static final String ZTYOSIRASEMONGON18       = "ztyosirasemongon18";
    public static final String ZTYOSIRASEMONGON19       = "ztyosirasemongon19";
    public static final String ZTYOSIRASEMONGON20       = "ztyosirasemongon20";
    public static final String ZTYOSIRASEMONGON21       = "ztyosirasemongon21";
    public static final String ZTYOSIRASEMONGON22       = "ztyosirasemongon22";
    public static final String ZTYOSIRASEMONGON23       = "ztyosirasemongon23";
    public static final String ZTYOSIRASEMONGON24       = "ztyosirasemongon24";
    public static final String ZTYOSIRASEMONGON25       = "ztyosirasemongon25";
    public static final String ZTYOSIRASEMONGON26       = "ztyosirasemongon26";
    public static final String ZTYOSIRASEMONGON27       = "ztyosirasemongon27";
    public static final String ZTYOSIRASEMONGON28       = "ztyosirasemongon28";
    public static final String ZTYOSIRASEMONGON29       = "ztyosirasemongon29";
    public static final String ZTYOSIRASEMONGON30       = "ztyosirasemongon30";
    public static final String ZTYOSIRASEMONGON31       = "ztyosirasemongon31";
    public static final String ZTYOSIRASEMONGON32       = "ztyosirasemongon32";
    public static final String ZTYOSIRASEMONGON33       = "ztyosirasemongon33";
    public static final String ZTYOSIRASEMONGON34       = "ztyosirasemongon34";
    public static final String ZTYOSIRASEMONGON35       = "ztyosirasemongon35";
    public static final String ZTYOSIRASEMONGON36       = "ztyosirasemongon36";
    public static final String ZTYOSIRASEMONGON37       = "ztyosirasemongon37";
    public static final String ZTYOSIRASEMONGON38       = "ztyosirasemongon38";
    public static final String ZTYOSIRASEMONGON39       = "ztyosirasemongon39";
    public static final String ZTYOSIRASEMONGON40       = "ztyosirasemongon40";
    public static final String ZTYOSIRASEMONGON41       = "ztyosirasemongon41";
    public static final String ZTYOSIRASEMONGON42       = "ztyosirasemongon42";
    public static final String ZTYOSIRASEMONGON43       = "ztyosirasemongon43";
    public static final String ZTYOSIRASEMONGON44       = "ztyosirasemongon44";
    public static final String ZTYOSIRASEMONGON45       = "ztyosirasemongon45";
    public static final String ZTYOSIRASEMONGON46       = "ztyosirasemongon46";
    public static final String ZTYOSIRASEMONGON47       = "ztyosirasemongon47";
    public static final String ZTYOSIRASEMONGON48       = "ztyosirasemongon48";
    public static final String ZTYOSIRASEMONGON49       = "ztyosirasemongon49";
    public static final String ZTYOSIRASEMONGON50       = "ztyosirasemongon50";
    public static final String ZTYYOBIV255              = "ztyyobiv255";
    public static final String ZTYANSYUYOUYOBIN10X10    = "ztyansyuyouyobin10x10";
    public static final String ZTYTEISYUTUSRMONGON1     = "ztyteisyutusrmongon1";
    public static final String ZTYTEISYUTUSRMONGON2     = "ztyteisyutusrmongon2";
    public static final String ZTYTEISYUTUSRMONGON3     = "ztyteisyutusrmongon3";
    public static final String ZTYMSGYOBI1              = "ztymsgyobi1";
    public static final String ZTYANSYUYOUYOBIN10X11    = "ztyansyuyouyobin10x11";
    public static final String ZTYSEIKYUUSYASYOMEIMONGON1 = "ztyseikyuusyasyomeimongon1";
    public static final String ZTYSEIKYUUSYASYOMEIMONGON2 = "ztyseikyuusyasyomeimongon2";
    public static final String ZTYSEIKYUUSYASYOMEIMONGON3 = "ztyseikyuusyasyomeimongon3";
    public static final String ZTYSEIKYUUSYASYOMEIMONGON4 = "ztyseikyuusyasyomeimongon4";
    public static final String ZTYSEIKYUUSYASYOMEIMONGON5 = "ztyseikyuusyasyomeimongon5";
    public static final String ZTYSEIKYUUSYASYOMEIMONGON6 = "ztyseikyuusyasyomeimongon6";
    public static final String ZTYSEIKYUUSYASYOMEIMONGON7 = "ztyseikyuusyasyomeimongon7";
    public static final String ZTYSEIKYUUSYASYOMEIMONGON8 = "ztyseikyuusyasyomeimongon8";
    public static final String ZTYSEIKYUUSYASYOMEIMONGON9 = "ztyseikyuusyasyomeimongon9";
    public static final String ZTYSEIKYUUSYAGENYNO      = "ztyseikyuusyagenyno";
    public static final String ZTYSEIKYUUSYAGENADR1     = "ztyseikyuusyagenadr1";
    public static final String ZTYSEIKYUUSYAGENADR2     = "ztyseikyuusyagenadr2";
    public static final String ZTYSEIKYUUSYAGENADR3     = "ztyseikyuusyagenadr3";
    public static final String ZTYSEIKYUUYAGENTELNO     = "ztyseikyuuyagentelno";
    public static final String ZTYTORITUGISYASYOZOKUNM  = "ztytoritugisyasyozokunm";
    public static final String ZTYTORITUGISYAKJNCD      = "ztytoritugisyakjncd";
    public static final String ZTYTORITUGISYANM         = "ztytoritugisyanm";
    public static final String ZTYHOZONKKNY             = "ztyhozonkkny";
    public static final String ZTYYOBIV168              = "ztyyobiv168";
    public static final String ZTYANSYUYOUYOBIN10X12    = "ztyansyuyouyobin10x12";
    public static final String ZTYTEISYUTUSRMONGON4     = "ztyteisyutusrmongon4";
    public static final String ZTYYOBIV155              = "ztyyobiv155";
    public static final String ZTYYOBIV97               = "ztyyobiv97";

    private final PKZT_SyoumetuTuutiTy primaryKey;

    public GenZT_SyoumetuTuutiTy() {
        primaryKey = new PKZT_SyoumetuTuutiTy();
    }

    public GenZT_SyoumetuTuutiTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        primaryKey = new PKZT_SyoumetuTuutiTy(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_SyoumetuTuutiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyoumetuTuutiTy> getMetaClass() {
        return QZT_SyoumetuTuutiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdkj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTYOUHYOUYMDKJ)
    public String getZtytyouhyouymdkj() {
        return ztytyouhyouymdkj;
    }

    @DataConvert("toMultiByte")
    public void setZtytyouhyouymdkj(String pZtytyouhyouymdkj) {
        ztytyouhyouymdkj = pZtytyouhyouymdkj;
    }

    @Id
    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztytantousitukbn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTANTOUSITUKBN)
    public String getZtytantousitukbn() {
        return ztytantousitukbn;
    }

    public void setZtytantousitukbn(String pZtytantousitukbn) {
        ztytantousitukbn = pZtytantousitukbn;
    }

    private String ztysksdoufuukbn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSKSDOUFUUKBN)
    public String getZtysksdoufuukbn() {
        return ztysksdoufuukbn;
    }

    public void setZtysksdoufuukbn(String pZtysksdoufuukbn) {
        ztysksdoufuukbn = pZtysksdoufuukbn;
    }

    private String ztymynosinkokuiraidoufuukbn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYMYNOSINKOKUIRAIDOUFUUKBN)
    public String getZtymynosinkokuiraidoufuukbn() {
        return ztymynosinkokuiraidoufuukbn;
    }

    public void setZtymynosinkokuiraidoufuukbn(String pZtymynosinkokuiraidoufuukbn) {
        ztymynosinkokuiraidoufuukbn = pZtymynosinkokuiraidoufuukbn;
    }

    @Id
    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return getPrimaryKey().getZtysikibetuno();
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        getPrimaryKey().setZtysikibetuno(pZtysikibetuno);
    }

    private String ztykwsratemongonumukbn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYKWSRATEMONGONUMUKBN)
    public String getZtykwsratemongonumukbn() {
        return ztykwsratemongonumukbn;
    }

    public void setZtykwsratemongonumukbn(String pZtykwsratemongonumukbn) {
        ztykwsratemongonumukbn = pZtykwsratemongonumukbn;
    }

    private String ztyyobiv13;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV13)
    public String getZtyyobiv13() {
        return ztyyobiv13;
    }

    public void setZtyyobiv13(String pZtyyobiv13) {
        ztyyobiv13 = pZtyyobiv13;
    }

    private String ztyansyuyouyobin10;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10)
    public String getZtyansyuyouyobin10() {
        return ztyansyuyouyobin10;
    }

    public void setZtyansyuyouyobin10(String pZtyansyuyouyobin10) {
        ztyansyuyouyobin10 = pZtyansyuyouyobin10;
    }

    private String ztyshskyno;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHSNMKJ)
    public String getZtyshsnmkj() {
        return ztyshsnmkj;
    }

    public void setZtyshsnmkj(String pZtyshsnmkj) {
        ztyshsnmkj = pZtyshsnmkj;
    }

    private String ztyyobiv44;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV44)
    public String getZtyyobiv44() {
        return ztyyobiv44;
    }

    public void setZtyyobiv44(String pZtyyobiv44) {
        ztyyobiv44 = pZtyyobiv44;
    }

    private String ztyansyuyouyobin10x2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X2)
    public String getZtyansyuyouyobin10x2() {
        return ztyansyuyouyobin10x2;
    }

    public void setZtyansyuyouyobin10x2(String pZtyansyuyouyobin10x2) {
        ztyansyuyouyobin10x2 = pZtyansyuyouyobin10x2;
    }

    private String ztytawyno;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytoiawasekaisyanmkj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTOIAWASEKAISYANMKJ)
    public String getZtytoiawasekaisyanmkj() {
        return ztytoiawasekaisyanmkj;
    }

    public void setZtytoiawasekaisyanmkj(String pZtytoiawasekaisyanmkj) {
        ztytoiawasekaisyanmkj = pZtytoiawasekaisyanmkj;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1x18keta;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTAWTELUKTKKANOU1X18KETA)
    public String getZtytawteluktkkanou1x18keta() {
        return ztytawteluktkkanou1x18keta;
    }

    public void setZtytawteluktkkanou1x18keta(String pZtytawteluktkkanou1x18keta) {
        ztytawteluktkkanou1x18keta = pZtytawteluktkkanou1x18keta;
    }

    private String ztytawteluktkkanou2x18keta;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTAWTELUKTKKANOU2X18KETA)
    public String getZtytawteluktkkanou2x18keta() {
        return ztytawteluktkkanou2x18keta;
    }

    public void setZtytawteluktkkanou2x18keta(String pZtytawteluktkkanou2x18keta) {
        ztytawteluktkkanou2x18keta = pZtytawteluktkkanou2x18keta;
    }

    private String ztyyobiv50;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV50)
    public String getZtyyobiv50() {
        return ztyyobiv50;
    }

    public void setZtyyobiv50(String pZtyyobiv50) {
        ztyyobiv50 = pZtyyobiv50;
    }

    private String ztyansyuyouyobin10x3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X3)
    public String getZtyansyuyouyobin10x3() {
        return ztyansyuyouyobin10x3;
    }

    public void setZtyansyuyouyobin10x3(String pZtyansyuyouyobin10x3) {
        ztyansyuyouyobin10x3 = pZtyansyuyouyobin10x3;
    }

    private String ztyaisatumongon50keta1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYAISATUMONGON50KETA1)
    public String getZtyaisatumongon50keta1() {
        return ztyaisatumongon50keta1;
    }

    public void setZtyaisatumongon50keta1(String pZtyaisatumongon50keta1) {
        ztyaisatumongon50keta1 = pZtyaisatumongon50keta1;
    }

    private String ztyaisatumongon50keta2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYAISATUMONGON50KETA2)
    public String getZtyaisatumongon50keta2() {
        return ztyaisatumongon50keta2;
    }

    public void setZtyaisatumongon50keta2(String pZtyaisatumongon50keta2) {
        ztyaisatumongon50keta2 = pZtyaisatumongon50keta2;
    }

    private String ztyaisatumongon50keta3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYAISATUMONGON50KETA3)
    public String getZtyaisatumongon50keta3() {
        return ztyaisatumongon50keta3;
    }

    public void setZtyaisatumongon50keta3(String pZtyaisatumongon50keta3) {
        ztyaisatumongon50keta3 = pZtyaisatumongon50keta3;
    }

    private String ztyaisatumongon50keta4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYAISATUMONGON50KETA4)
    public String getZtyaisatumongon50keta4() {
        return ztyaisatumongon50keta4;
    }

    public void setZtyaisatumongon50keta4(String pZtyaisatumongon50keta4) {
        ztyaisatumongon50keta4 = pZtyaisatumongon50keta4;
    }

    private String ztyaisatumongon50keta5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYAISATUMONGON50KETA5)
    public String getZtyaisatumongon50keta5() {
        return ztyaisatumongon50keta5;
    }

    public void setZtyaisatumongon50keta5(String pZtyaisatumongon50keta5) {
        ztyaisatumongon50keta5 = pZtyaisatumongon50keta5;
    }

    private String ztyaisatumongon50keta6;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYAISATUMONGON50KETA6)
    public String getZtyaisatumongon50keta6() {
        return ztyaisatumongon50keta6;
    }

    public void setZtyaisatumongon50keta6(String pZtyaisatumongon50keta6) {
        ztyaisatumongon50keta6 = pZtyaisatumongon50keta6;
    }

    private String ztyyobiv120;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV120)
    public String getZtyyobiv120() {
        return ztyyobiv120;
    }

    public void setZtyyobiv120(String pZtyyobiv120) {
        ztyyobiv120 = pZtyyobiv120;
    }

    private String ztyansyuyouyobin10x4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X4)
    public String getZtyansyuyouyobin10x4() {
        return ztyansyuyouyobin10x4;
    }

    public void setZtyansyuyouyobin10x4(String pZtyansyuyouyobin10x4) {
        ztyansyuyouyobin10x4 = pZtyansyuyouyobin10x4;
    }

    private String ztysyono2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztykyknmkj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztykykymdseireki;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYKYKYMDSEIREKI)
    public String getZtykykymdseireki() {
        return ztykykymdseireki;
    }

    public void setZtykykymdseireki(String pZtykykymdseireki) {
        ztykykymdseireki = pZtykykymdseireki;
    }

    private String ztyhknsyurui30keta;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYHKNSYURUI30KETA)
    public String getZtyhknsyurui30keta() {
        return ztyhknsyurui30keta;
    }

    public void setZtyhknsyurui30keta(String pZtyhknsyurui30keta) {
        ztyhknsyurui30keta = pZtyhknsyurui30keta;
    }

    private String ztysyoumetuymd;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSYOUMETUYMD)
    public String getZtysyoumetuymd() {
        return ztysyoumetuymd;
    }

    public void setZtysyoumetuymd(String pZtysyoumetuymd) {
        ztysyoumetuymd = pZtysyoumetuymd;
    }

    private String ztyoharaimodosikn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOHARAIMODOSIKN)
    public String getZtyoharaimodosikn() {
        return ztyoharaimodosikn;
    }

    public void setZtyoharaimodosikn(String pZtyoharaimodosikn) {
        ztyoharaimodosikn = pZtyoharaimodosikn;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }

    private String ztyansyuyouyobin10x5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X5)
    public String getZtyansyuyouyobin10x5() {
        return ztyansyuyouyobin10x5;
    }

    public void setZtyansyuyouyobin10x5(String pZtyansyuyouyobin10x5) {
        ztyansyuyouyobin10x5 = pZtyansyuyouyobin10x5;
    }

    private String ztyshrymd11keta;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRYMD11KETA)
    public String getZtyshrymd11keta() {
        return ztyshrymd11keta;
    }

    public void setZtyshrymd11keta(String pZtyshrymd11keta) {
        ztyshrymd11keta = pZtyshrymd11keta;
    }

    private String ztytekiyou1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU1)
    public String getZtytekiyou1() {
        return ztytekiyou1;
    }

    public void setZtytekiyou1(String pZtytekiyou1) {
        ztytekiyou1 = pZtytekiyou1;
    }

    private String ztyshrkngkmeisaihugou1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU1)
    public String getZtyshrkngkmeisaihugou1() {
        return ztyshrkngkmeisaihugou1;
    }

    public void setZtyshrkngkmeisaihugou1(String pZtyshrkngkmeisaihugou1) {
        ztyshrkngkmeisaihugou1 = pZtyshrkngkmeisaihugou1;
    }

    private String ztyshrgkmeisai1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI1)
    public String getZtyshrgkmeisai1() {
        return ztyshrgkmeisai1;
    }

    public void setZtyshrgkmeisai1(String pZtyshrgkmeisai1) {
        ztyshrgkmeisai1 = pZtyshrgkmeisai1;
    }

    private String ztyshrgktuukasyu1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU1)
    public String getZtyshrgktuukasyu1() {
        return ztyshrgktuukasyu1;
    }

    public void setZtyshrgktuukasyu1(String pZtyshrgktuukasyu1) {
        ztyshrgktuukasyu1 = pZtyshrgktuukasyu1;
    }

    private String ztybikou1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU1)
    public String getZtybikou1() {
        return ztybikou1;
    }

    public void setZtybikou1(String pZtybikou1) {
        ztybikou1 = pZtybikou1;
    }

    private String ztytekiyou2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU2)
    public String getZtytekiyou2() {
        return ztytekiyou2;
    }

    public void setZtytekiyou2(String pZtytekiyou2) {
        ztytekiyou2 = pZtytekiyou2;
    }

    private String ztyshrkngkmeisaihugou2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU2)
    public String getZtyshrkngkmeisaihugou2() {
        return ztyshrkngkmeisaihugou2;
    }

    public void setZtyshrkngkmeisaihugou2(String pZtyshrkngkmeisaihugou2) {
        ztyshrkngkmeisaihugou2 = pZtyshrkngkmeisaihugou2;
    }

    private String ztyshrgkmeisai2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI2)
    public String getZtyshrgkmeisai2() {
        return ztyshrgkmeisai2;
    }

    public void setZtyshrgkmeisai2(String pZtyshrgkmeisai2) {
        ztyshrgkmeisai2 = pZtyshrgkmeisai2;
    }

    private String ztyshrgktuukasyu2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU2)
    public String getZtyshrgktuukasyu2() {
        return ztyshrgktuukasyu2;
    }

    public void setZtyshrgktuukasyu2(String pZtyshrgktuukasyu2) {
        ztyshrgktuukasyu2 = pZtyshrgktuukasyu2;
    }

    private String ztybikou2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU2)
    public String getZtybikou2() {
        return ztybikou2;
    }

    public void setZtybikou2(String pZtybikou2) {
        ztybikou2 = pZtybikou2;
    }

    private String ztytekiyou3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU3)
    public String getZtytekiyou3() {
        return ztytekiyou3;
    }

    public void setZtytekiyou3(String pZtytekiyou3) {
        ztytekiyou3 = pZtytekiyou3;
    }

    private String ztyshrkngkmeisaihugou3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU3)
    public String getZtyshrkngkmeisaihugou3() {
        return ztyshrkngkmeisaihugou3;
    }

    public void setZtyshrkngkmeisaihugou3(String pZtyshrkngkmeisaihugou3) {
        ztyshrkngkmeisaihugou3 = pZtyshrkngkmeisaihugou3;
    }

    private String ztyshrgkmeisai3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI3)
    public String getZtyshrgkmeisai3() {
        return ztyshrgkmeisai3;
    }

    public void setZtyshrgkmeisai3(String pZtyshrgkmeisai3) {
        ztyshrgkmeisai3 = pZtyshrgkmeisai3;
    }

    private String ztyshrgktuukasyu3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU3)
    public String getZtyshrgktuukasyu3() {
        return ztyshrgktuukasyu3;
    }

    public void setZtyshrgktuukasyu3(String pZtyshrgktuukasyu3) {
        ztyshrgktuukasyu3 = pZtyshrgktuukasyu3;
    }

    private String ztybikou3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU3)
    public String getZtybikou3() {
        return ztybikou3;
    }

    public void setZtybikou3(String pZtybikou3) {
        ztybikou3 = pZtybikou3;
    }

    private String ztytekiyou4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU4)
    public String getZtytekiyou4() {
        return ztytekiyou4;
    }

    public void setZtytekiyou4(String pZtytekiyou4) {
        ztytekiyou4 = pZtytekiyou4;
    }

    private String ztyshrkngkmeisaihugou4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU4)
    public String getZtyshrkngkmeisaihugou4() {
        return ztyshrkngkmeisaihugou4;
    }

    public void setZtyshrkngkmeisaihugou4(String pZtyshrkngkmeisaihugou4) {
        ztyshrkngkmeisaihugou4 = pZtyshrkngkmeisaihugou4;
    }

    private String ztyshrgkmeisai4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI4)
    public String getZtyshrgkmeisai4() {
        return ztyshrgkmeisai4;
    }

    public void setZtyshrgkmeisai4(String pZtyshrgkmeisai4) {
        ztyshrgkmeisai4 = pZtyshrgkmeisai4;
    }

    private String ztyshrgktuukasyu4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU4)
    public String getZtyshrgktuukasyu4() {
        return ztyshrgktuukasyu4;
    }

    public void setZtyshrgktuukasyu4(String pZtyshrgktuukasyu4) {
        ztyshrgktuukasyu4 = pZtyshrgktuukasyu4;
    }

    private String ztybikou4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU4)
    public String getZtybikou4() {
        return ztybikou4;
    }

    public void setZtybikou4(String pZtybikou4) {
        ztybikou4 = pZtybikou4;
    }

    private String ztytekiyou5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU5)
    public String getZtytekiyou5() {
        return ztytekiyou5;
    }

    public void setZtytekiyou5(String pZtytekiyou5) {
        ztytekiyou5 = pZtytekiyou5;
    }

    private String ztyshrkngkmeisaihugou5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU5)
    public String getZtyshrkngkmeisaihugou5() {
        return ztyshrkngkmeisaihugou5;
    }

    public void setZtyshrkngkmeisaihugou5(String pZtyshrkngkmeisaihugou5) {
        ztyshrkngkmeisaihugou5 = pZtyshrkngkmeisaihugou5;
    }

    private String ztyshrgkmeisai5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI5)
    public String getZtyshrgkmeisai5() {
        return ztyshrgkmeisai5;
    }

    public void setZtyshrgkmeisai5(String pZtyshrgkmeisai5) {
        ztyshrgkmeisai5 = pZtyshrgkmeisai5;
    }

    private String ztyshrgktuukasyu5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU5)
    public String getZtyshrgktuukasyu5() {
        return ztyshrgktuukasyu5;
    }

    public void setZtyshrgktuukasyu5(String pZtyshrgktuukasyu5) {
        ztyshrgktuukasyu5 = pZtyshrgktuukasyu5;
    }

    private String ztybikou5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU5)
    public String getZtybikou5() {
        return ztybikou5;
    }

    public void setZtybikou5(String pZtybikou5) {
        ztybikou5 = pZtybikou5;
    }

    private String ztytekiyou6;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU6)
    public String getZtytekiyou6() {
        return ztytekiyou6;
    }

    public void setZtytekiyou6(String pZtytekiyou6) {
        ztytekiyou6 = pZtytekiyou6;
    }

    private String ztyshrkngkmeisaihugou6;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU6)
    public String getZtyshrkngkmeisaihugou6() {
        return ztyshrkngkmeisaihugou6;
    }

    public void setZtyshrkngkmeisaihugou6(String pZtyshrkngkmeisaihugou6) {
        ztyshrkngkmeisaihugou6 = pZtyshrkngkmeisaihugou6;
    }

    private String ztyshrgkmeisai6;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI6)
    public String getZtyshrgkmeisai6() {
        return ztyshrgkmeisai6;
    }

    public void setZtyshrgkmeisai6(String pZtyshrgkmeisai6) {
        ztyshrgkmeisai6 = pZtyshrgkmeisai6;
    }

    private String ztyshrgktuukasyu6;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU6)
    public String getZtyshrgktuukasyu6() {
        return ztyshrgktuukasyu6;
    }

    public void setZtyshrgktuukasyu6(String pZtyshrgktuukasyu6) {
        ztyshrgktuukasyu6 = pZtyshrgktuukasyu6;
    }

    private String ztybikou6;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU6)
    public String getZtybikou6() {
        return ztybikou6;
    }

    public void setZtybikou6(String pZtybikou6) {
        ztybikou6 = pZtybikou6;
    }

    private String ztytekiyou7;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU7)
    public String getZtytekiyou7() {
        return ztytekiyou7;
    }

    public void setZtytekiyou7(String pZtytekiyou7) {
        ztytekiyou7 = pZtytekiyou7;
    }

    private String ztyshrkngkmeisaihugou7;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU7)
    public String getZtyshrkngkmeisaihugou7() {
        return ztyshrkngkmeisaihugou7;
    }

    public void setZtyshrkngkmeisaihugou7(String pZtyshrkngkmeisaihugou7) {
        ztyshrkngkmeisaihugou7 = pZtyshrkngkmeisaihugou7;
    }

    private String ztyshrgkmeisai7;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI7)
    public String getZtyshrgkmeisai7() {
        return ztyshrgkmeisai7;
    }

    public void setZtyshrgkmeisai7(String pZtyshrgkmeisai7) {
        ztyshrgkmeisai7 = pZtyshrgkmeisai7;
    }

    private String ztyshrgktuukasyu7;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU7)
    public String getZtyshrgktuukasyu7() {
        return ztyshrgktuukasyu7;
    }

    public void setZtyshrgktuukasyu7(String pZtyshrgktuukasyu7) {
        ztyshrgktuukasyu7 = pZtyshrgktuukasyu7;
    }

    private String ztybikou7;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU7)
    public String getZtybikou7() {
        return ztybikou7;
    }

    public void setZtybikou7(String pZtybikou7) {
        ztybikou7 = pZtybikou7;
    }

    private String ztytekiyou8;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU8)
    public String getZtytekiyou8() {
        return ztytekiyou8;
    }

    public void setZtytekiyou8(String pZtytekiyou8) {
        ztytekiyou8 = pZtytekiyou8;
    }

    private String ztyshrkngkmeisaihugou8;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU8)
    public String getZtyshrkngkmeisaihugou8() {
        return ztyshrkngkmeisaihugou8;
    }

    public void setZtyshrkngkmeisaihugou8(String pZtyshrkngkmeisaihugou8) {
        ztyshrkngkmeisaihugou8 = pZtyshrkngkmeisaihugou8;
    }

    private String ztyshrgkmeisai8;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI8)
    public String getZtyshrgkmeisai8() {
        return ztyshrgkmeisai8;
    }

    public void setZtyshrgkmeisai8(String pZtyshrgkmeisai8) {
        ztyshrgkmeisai8 = pZtyshrgkmeisai8;
    }

    private String ztyshrgktuukasyu8;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU8)
    public String getZtyshrgktuukasyu8() {
        return ztyshrgktuukasyu8;
    }

    public void setZtyshrgktuukasyu8(String pZtyshrgktuukasyu8) {
        ztyshrgktuukasyu8 = pZtyshrgktuukasyu8;
    }

    private String ztybikou8;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU8)
    public String getZtybikou8() {
        return ztybikou8;
    }

    public void setZtybikou8(String pZtybikou8) {
        ztybikou8 = pZtybikou8;
    }

    private String ztytekiyou9;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU9)
    public String getZtytekiyou9() {
        return ztytekiyou9;
    }

    public void setZtytekiyou9(String pZtytekiyou9) {
        ztytekiyou9 = pZtytekiyou9;
    }

    private String ztyshrkngkmeisaihugou9;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU9)
    public String getZtyshrkngkmeisaihugou9() {
        return ztyshrkngkmeisaihugou9;
    }

    public void setZtyshrkngkmeisaihugou9(String pZtyshrkngkmeisaihugou9) {
        ztyshrkngkmeisaihugou9 = pZtyshrkngkmeisaihugou9;
    }

    private String ztyshrgkmeisai9;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI9)
    public String getZtyshrgkmeisai9() {
        return ztyshrgkmeisai9;
    }

    public void setZtyshrgkmeisai9(String pZtyshrgkmeisai9) {
        ztyshrgkmeisai9 = pZtyshrgkmeisai9;
    }

    private String ztyshrgktuukasyu9;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU9)
    public String getZtyshrgktuukasyu9() {
        return ztyshrgktuukasyu9;
    }

    public void setZtyshrgktuukasyu9(String pZtyshrgktuukasyu9) {
        ztyshrgktuukasyu9 = pZtyshrgktuukasyu9;
    }

    private String ztybikou9;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU9)
    public String getZtybikou9() {
        return ztybikou9;
    }

    public void setZtybikou9(String pZtybikou9) {
        ztybikou9 = pZtybikou9;
    }

    private String ztytekiyou10;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEKIYOU10)
    public String getZtytekiyou10() {
        return ztytekiyou10;
    }

    public void setZtytekiyou10(String pZtytekiyou10) {
        ztytekiyou10 = pZtytekiyou10;
    }

    private String ztyshrkngkmeisaihugou10;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKNGKMEISAIHUGOU10)
    public String getZtyshrkngkmeisaihugou10() {
        return ztyshrkngkmeisaihugou10;
    }

    public void setZtyshrkngkmeisaihugou10(String pZtyshrkngkmeisaihugou10) {
        ztyshrkngkmeisaihugou10 = pZtyshrkngkmeisaihugou10;
    }

    private String ztyshrgkmeisai10;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKMEISAI10)
    public String getZtyshrgkmeisai10() {
        return ztyshrgkmeisai10;
    }

    public void setZtyshrgkmeisai10(String pZtyshrgkmeisai10) {
        ztyshrgkmeisai10 = pZtyshrgkmeisai10;
    }

    private String ztyshrgktuukasyu10;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKTUUKASYU10)
    public String getZtyshrgktuukasyu10() {
        return ztyshrgktuukasyu10;
    }

    public void setZtyshrgktuukasyu10(String pZtyshrgktuukasyu10) {
        ztyshrgktuukasyu10 = pZtyshrgktuukasyu10;
    }

    private String ztybikou10;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBIKOU10)
    public String getZtybikou10() {
        return ztybikou10;
    }

    public void setZtybikou10(String pZtybikou10) {
        ztybikou10 = pZtybikou10;
    }

    private String ztyshrgkgoukei;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRGKGOUKEI)
    public String getZtyshrgkgoukei() {
        return ztyshrgkgoukei;
    }

    public void setZtyshrgkgoukei(String pZtyshrgkgoukei) {
        ztyshrgkgoukei = pZtyshrgkgoukei;
    }

    private String ztyshrtuukasyu;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRTUUKASYU)
    public String getZtyshrtuukasyu() {
        return ztyshrtuukasyu;
    }

    public void setZtyshrtuukasyu(String pZtyshrtuukasyu) {
        ztyshrtuukasyu = pZtyshrtuukasyu;
    }

    private String ztyyobiv215;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV215)
    public String getZtyyobiv215() {
        return ztyyobiv215;
    }

    public void setZtyyobiv215(String pZtyyobiv215) {
        ztyyobiv215 = pZtyyobiv215;
    }

    private String ztyansyuyouyobin10x6;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X6)
    public String getZtyansyuyouyobin10x6() {
        return ztyansyuyouyobin10x6;
    }

    public void setZtyansyuyouyobin10x6(String pZtyansyuyouyobin10x6) {
        ztyansyuyouyobin10x6 = pZtyansyuyouyobin10x6;
    }

    private String ztyshrnaiyouhskmongon1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRNAIYOUHSKMONGON1)
    public String getZtyshrnaiyouhskmongon1() {
        return ztyshrnaiyouhskmongon1;
    }

    public void setZtyshrnaiyouhskmongon1(String pZtyshrnaiyouhskmongon1) {
        ztyshrnaiyouhskmongon1 = pZtyshrnaiyouhskmongon1;
    }

    private String ztyshrnaiyouhskmongon2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRNAIYOUHSKMONGON2)
    public String getZtyshrnaiyouhskmongon2() {
        return ztyshrnaiyouhskmongon2;
    }

    public void setZtyshrnaiyouhskmongon2(String pZtyshrnaiyouhskmongon2) {
        ztyshrnaiyouhskmongon2 = pZtyshrnaiyouhskmongon2;
    }

    private String ztyyobiv40;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV40)
    public String getZtyyobiv40() {
        return ztyyobiv40;
    }

    public void setZtyyobiv40(String pZtyyobiv40) {
        ztyyobiv40 = pZtyyobiv40;
    }

    private String ztyansyuyouyobin10x7;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X7)
    public String getZtyansyuyouyobin10x7() {
        return ztyansyuyouyobin10x7;
    }

    public void setZtyansyuyouyobin10x7(String pZtyansyuyouyobin10x7) {
        ztyansyuyouyobin10x7 = pZtyansyuyouyobin10x7;
    }

    private String ztybanknmkj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYBANKNMKJ)
    public String getZtybanknmkj() {
        return ztybanknmkj;
    }

    public void setZtybanknmkj(String pZtybanknmkj) {
        ztybanknmkj = pZtybanknmkj;
    }

    private String ztysitennmkj;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSITENNMKJ)
    public String getZtysitennmkj() {
        return ztysitennmkj;
    }

    public void setZtysitennmkj(String pZtysitennmkj) {
        ztysitennmkj = pZtysitennmkj;
    }

    private String ztyyokinkbn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOKINKBN)
    public String getZtyyokinkbn() {
        return ztyyokinkbn;
    }

    public void setZtyyokinkbn(String pZtyyokinkbn) {
        ztyyokinkbn = pZtyyokinkbn;
    }

    private String ztykouzano12keta;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYKOUZANO12KETA)
    public String getZtykouzano12keta() {
        return ztykouzano12keta;
    }

    public void setZtykouzano12keta(String pZtykouzano12keta) {
        ztykouzano12keta = pZtykouzano12keta;
    }

    private String ztykzmeiginmknhan;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYKZMEIGINMKNHAN)
    public String getZtykzmeiginmknhan() {
        return ztykzmeiginmknhan;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setZtykzmeiginmknhan(String pZtykzmeiginmknhan) {
        ztykzmeiginmknhan = pZtykzmeiginmknhan;
    }

    private String ztykzsyurui;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYKZSYURUI)
    public String getZtykzsyurui() {
        return ztykzsyurui;
    }

    public void setZtykzsyurui(String pZtykzsyurui) {
        ztykzsyurui = pZtykzsyurui;
    }

    private String ztyyobiv26x2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV26X2)
    public String getZtyyobiv26x2() {
        return ztyyobiv26x2;
    }

    public void setZtyyobiv26x2(String pZtyyobiv26x2) {
        ztyyobiv26x2 = pZtyyobiv26x2;
    }

    private String ztyansyuyouyobin10x8;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X8)
    public String getZtyansyuyouyobin10x8() {
        return ztyansyuyouyobin10x8;
    }

    public void setZtyansyuyouyobin10x8(String pZtyansyuyouyobin10x8) {
        ztyansyuyouyobin10x8 = pZtyansyuyouyobin10x8;
    }

    private String ztysynykngk;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSYNYKNGK)
    public String getZtysynykngk() {
        return ztysynykngk;
    }

    public void setZtysynykngk(String pZtysynykngk) {
        ztysynykngk = pZtysynykngk;
    }

    private String ztysynykngktuukasyu;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSYNYKNGKTUUKASYU)
    public String getZtysynykngktuukasyu() {
        return ztysynykngktuukasyu;
    }

    public void setZtysynykngktuukasyu(String pZtysynykngktuukasyu) {
        ztysynykngktuukasyu = pZtysynykngktuukasyu;
    }

    private String ztyhtykeihi;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYHTYKEIHI)
    public String getZtyhtykeihi() {
        return ztyhtykeihi;
    }

    public void setZtyhtykeihi(String pZtyhtykeihi) {
        ztyhtykeihi = pZtyhtykeihi;
    }

    private String ztyhtykeihituukasyu;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYHTYKEIHITUUKASYU)
    public String getZtyhtykeihituukasyu() {
        return ztyhtykeihituukasyu;
    }

    public void setZtyhtykeihituukasyu(String pZtyhtykeihituukasyu) {
        ztyhtykeihituukasyu = pZtyhtykeihituukasyu;
    }

    private String ztyshrkyksyahtykeihi;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKYKSYAHTYKEIHI)
    public String getZtyshrkyksyahtykeihi() {
        return ztyshrkyksyahtykeihi;
    }

    public void setZtyshrkyksyahtykeihi(String pZtyshrkyksyahtykeihi) {
        ztyshrkyksyahtykeihi = pZtyshrkyksyahtykeihi;
    }

    private String ztyshrkykhtykeihituukasyu;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSHRKYKHTYKEIHITUUKASYU)
    public String getZtyshrkykhtykeihituukasyu() {
        return ztyshrkykhtykeihituukasyu;
    }

    public void setZtyshrkykhtykeihituukasyu(String pZtyshrkykhtykeihituukasyu) {
        ztyshrkykhtykeihituukasyu = pZtyshrkykhtykeihituukasyu;
    }

    private String ztygsbnrkzthtykeihi;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYGSBNRKZTHTYKEIHI)
    public String getZtygsbnrkzthtykeihi() {
        return ztygsbnrkzthtykeihi;
    }

    public void setZtygsbnrkzthtykeihi(String pZtygsbnrkzthtykeihi) {
        ztygsbnrkzthtykeihi = pZtygsbnrkzthtykeihi;
    }

    private String ztygsbnrkzthtykeihituksyu;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYGSBNRKZTHTYKEIHITUKSYU)
    public String getZtygsbnrkzthtykeihituksyu() {
        return ztygsbnrkzthtykeihituksyu;
    }

    public void setZtygsbnrkzthtykeihituksyu(String pZtygsbnrkzthtykeihituksyu) {
        ztygsbnrkzthtykeihituksyu = pZtygsbnrkzthtykeihituksyu;
    }

    private String ztygsbnrkztsaeki;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYGSBNRKZTSAEKI)
    public String getZtygsbnrkztsaeki() {
        return ztygsbnrkztsaeki;
    }

    public void setZtygsbnrkztsaeki(String pZtygsbnrkztsaeki) {
        ztygsbnrkztsaeki = pZtygsbnrkztsaeki;
    }

    private String ztygsbnrkztsaekituksyu;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYGSBNRKZTSAEKITUKSYU)
    public String getZtygsbnrkztsaekituksyu() {
        return ztygsbnrkztsaekituksyu;
    }

    public void setZtygsbnrkztsaekituksyu(String pZtygsbnrkztsaekituksyu) {
        ztygsbnrkztsaekituksyu = pZtygsbnrkztsaekituksyu;
    }

    private String ztyzeimunaiyouhensyuctrlkbn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYZEIMUNAIYOUHENSYUCTRLKBN)
    public String getZtyzeimunaiyouhensyuctrlkbn() {
        return ztyzeimunaiyouhensyuctrlkbn;
    }

    public void setZtyzeimunaiyouhensyuctrlkbn(String pZtyzeimunaiyouhensyuctrlkbn) {
        ztyzeimunaiyouhensyuctrlkbn = pZtyzeimunaiyouhensyuctrlkbn;
    }

    private String ztyzeimumongonoutkbn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYZEIMUMONGONOUTKBN)
    public String getZtyzeimumongonoutkbn() {
        return ztyzeimumongonoutkbn;
    }

    public void setZtyzeimumongonoutkbn(String pZtyzeimumongonoutkbn) {
        ztyzeimumongonoutkbn = pZtyzeimumongonoutkbn;
    }

    private String ztyzeimumongon1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYZEIMUMONGON1)
    public String getZtyzeimumongon1() {
        return ztyzeimumongon1;
    }

    public void setZtyzeimumongon1(String pZtyzeimumongon1) {
        ztyzeimumongon1 = pZtyzeimumongon1;
    }

    private String ztyzeimumongon2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYZEIMUMONGON2)
    public String getZtyzeimumongon2() {
        return ztyzeimumongon2;
    }

    public void setZtyzeimumongon2(String pZtyzeimumongon2) {
        ztyzeimumongon2 = pZtyzeimumongon2;
    }

    private String ztyzeimumongon3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYZEIMUMONGON3)
    public String getZtyzeimumongon3() {
        return ztyzeimumongon3;
    }

    public void setZtyzeimumongon3(String pZtyzeimumongon3) {
        ztyzeimumongon3 = pZtyzeimumongon3;
    }

    private String ztyzeimumongon4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYZEIMUMONGON4)
    public String getZtyzeimumongon4() {
        return ztyzeimumongon4;
    }

    public void setZtyzeimumongon4(String pZtyzeimumongon4) {
        ztyzeimumongon4 = pZtyzeimumongon4;
    }

    private String ztyzeimumongon5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYZEIMUMONGON5)
    public String getZtyzeimumongon5() {
        return ztyzeimumongon5;
    }

    public void setZtyzeimumongon5(String pZtyzeimumongon5) {
        ztyzeimumongon5 = pZtyzeimumongon5;
    }

    private String ztyyendthnkzeimuinfohskkbn;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYENDTHNKZEIMUINFOHSKKBN)
    public String getZtyyendthnkzeimuinfohskkbn() {
        return ztyyendthnkzeimuinfohskkbn;
    }

    public void setZtyyendthnkzeimuinfohskkbn(String pZtyyendthnkzeimuinfohskkbn) {
        ztyyendthnkzeimuinfohskkbn = pZtyyendthnkzeimuinfohskkbn;
    }

    private String ztyyobiv74;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV74)
    public String getZtyyobiv74() {
        return ztyyobiv74;
    }

    public void setZtyyobiv74(String pZtyyobiv74) {
        ztyyobiv74 = pZtyyobiv74;
    }

    private String ztyansyuyouyobin10x9;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X9)
    public String getZtyansyuyouyobin10x9() {
        return ztyansyuyouyobin10x9;
    }

    public void setZtyansyuyouyobin10x9(String pZtyansyuyouyobin10x9) {
        ztyansyuyouyobin10x9 = pZtyansyuyouyobin10x9;
    }

    private String ztyosirasehyoudai;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEHYOUDAI)
    public String getZtyosirasehyoudai() {
        return ztyosirasehyoudai;
    }

    public void setZtyosirasehyoudai(String pZtyosirasehyoudai) {
        ztyosirasehyoudai = pZtyosirasehyoudai;
    }

    private String ztyosirasemongon1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON1)
    public String getZtyosirasemongon1() {
        return ztyosirasemongon1;
    }

    public void setZtyosirasemongon1(String pZtyosirasemongon1) {
        ztyosirasemongon1 = pZtyosirasemongon1;
    }

    private String ztyosirasemongon2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON2)
    public String getZtyosirasemongon2() {
        return ztyosirasemongon2;
    }

    public void setZtyosirasemongon2(String pZtyosirasemongon2) {
        ztyosirasemongon2 = pZtyosirasemongon2;
    }

    private String ztyosirasemongon3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON3)
    public String getZtyosirasemongon3() {
        return ztyosirasemongon3;
    }

    public void setZtyosirasemongon3(String pZtyosirasemongon3) {
        ztyosirasemongon3 = pZtyosirasemongon3;
    }

    private String ztyosirasemongon4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON4)
    public String getZtyosirasemongon4() {
        return ztyosirasemongon4;
    }

    public void setZtyosirasemongon4(String pZtyosirasemongon4) {
        ztyosirasemongon4 = pZtyosirasemongon4;
    }

    private String ztyosirasemongon5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON5)
    public String getZtyosirasemongon5() {
        return ztyosirasemongon5;
    }

    public void setZtyosirasemongon5(String pZtyosirasemongon5) {
        ztyosirasemongon5 = pZtyosirasemongon5;
    }

    private String ztyosirasemongon6;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON6)
    public String getZtyosirasemongon6() {
        return ztyosirasemongon6;
    }

    public void setZtyosirasemongon6(String pZtyosirasemongon6) {
        ztyosirasemongon6 = pZtyosirasemongon6;
    }

    private String ztyosirasemongon7;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON7)
    public String getZtyosirasemongon7() {
        return ztyosirasemongon7;
    }

    public void setZtyosirasemongon7(String pZtyosirasemongon7) {
        ztyosirasemongon7 = pZtyosirasemongon7;
    }

    private String ztyosirasemongon8;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON8)
    public String getZtyosirasemongon8() {
        return ztyosirasemongon8;
    }

    public void setZtyosirasemongon8(String pZtyosirasemongon8) {
        ztyosirasemongon8 = pZtyosirasemongon8;
    }

    private String ztyosirasemongon9;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON9)
    public String getZtyosirasemongon9() {
        return ztyosirasemongon9;
    }

    public void setZtyosirasemongon9(String pZtyosirasemongon9) {
        ztyosirasemongon9 = pZtyosirasemongon9;
    }

    private String ztyosirasemongon10;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON10)
    public String getZtyosirasemongon10() {
        return ztyosirasemongon10;
    }

    public void setZtyosirasemongon10(String pZtyosirasemongon10) {
        ztyosirasemongon10 = pZtyosirasemongon10;
    }

    private String ztyosirasemongon11;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON11)
    public String getZtyosirasemongon11() {
        return ztyosirasemongon11;
    }

    public void setZtyosirasemongon11(String pZtyosirasemongon11) {
        ztyosirasemongon11 = pZtyosirasemongon11;
    }

    private String ztyosirasemongon12;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON12)
    public String getZtyosirasemongon12() {
        return ztyosirasemongon12;
    }

    public void setZtyosirasemongon12(String pZtyosirasemongon12) {
        ztyosirasemongon12 = pZtyosirasemongon12;
    }

    private String ztyosirasemongon13;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON13)
    public String getZtyosirasemongon13() {
        return ztyosirasemongon13;
    }

    public void setZtyosirasemongon13(String pZtyosirasemongon13) {
        ztyosirasemongon13 = pZtyosirasemongon13;
    }

    private String ztyosirasemongon14;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON14)
    public String getZtyosirasemongon14() {
        return ztyosirasemongon14;
    }

    public void setZtyosirasemongon14(String pZtyosirasemongon14) {
        ztyosirasemongon14 = pZtyosirasemongon14;
    }

    private String ztyosirasemongon15;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON15)
    public String getZtyosirasemongon15() {
        return ztyosirasemongon15;
    }

    public void setZtyosirasemongon15(String pZtyosirasemongon15) {
        ztyosirasemongon15 = pZtyosirasemongon15;
    }

    private String ztyosirasemongon16;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON16)
    public String getZtyosirasemongon16() {
        return ztyosirasemongon16;
    }

    public void setZtyosirasemongon16(String pZtyosirasemongon16) {
        ztyosirasemongon16 = pZtyosirasemongon16;
    }

    private String ztyosirasemongon17;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON17)
    public String getZtyosirasemongon17() {
        return ztyosirasemongon17;
    }

    public void setZtyosirasemongon17(String pZtyosirasemongon17) {
        ztyosirasemongon17 = pZtyosirasemongon17;
    }

    private String ztyosirasemongon18;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON18)
    public String getZtyosirasemongon18() {
        return ztyosirasemongon18;
    }

    public void setZtyosirasemongon18(String pZtyosirasemongon18) {
        ztyosirasemongon18 = pZtyosirasemongon18;
    }

    private String ztyosirasemongon19;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON19)
    public String getZtyosirasemongon19() {
        return ztyosirasemongon19;
    }

    public void setZtyosirasemongon19(String pZtyosirasemongon19) {
        ztyosirasemongon19 = pZtyosirasemongon19;
    }

    private String ztyosirasemongon20;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON20)
    public String getZtyosirasemongon20() {
        return ztyosirasemongon20;
    }

    public void setZtyosirasemongon20(String pZtyosirasemongon20) {
        ztyosirasemongon20 = pZtyosirasemongon20;
    }

    private String ztyosirasemongon21;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON21)
    public String getZtyosirasemongon21() {
        return ztyosirasemongon21;
    }

    public void setZtyosirasemongon21(String pZtyosirasemongon21) {
        ztyosirasemongon21 = pZtyosirasemongon21;
    }

    private String ztyosirasemongon22;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON22)
    public String getZtyosirasemongon22() {
        return ztyosirasemongon22;
    }

    public void setZtyosirasemongon22(String pZtyosirasemongon22) {
        ztyosirasemongon22 = pZtyosirasemongon22;
    }

    private String ztyosirasemongon23;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON23)
    public String getZtyosirasemongon23() {
        return ztyosirasemongon23;
    }

    public void setZtyosirasemongon23(String pZtyosirasemongon23) {
        ztyosirasemongon23 = pZtyosirasemongon23;
    }

    private String ztyosirasemongon24;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON24)
    public String getZtyosirasemongon24() {
        return ztyosirasemongon24;
    }

    public void setZtyosirasemongon24(String pZtyosirasemongon24) {
        ztyosirasemongon24 = pZtyosirasemongon24;
    }

    private String ztyosirasemongon25;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON25)
    public String getZtyosirasemongon25() {
        return ztyosirasemongon25;
    }

    public void setZtyosirasemongon25(String pZtyosirasemongon25) {
        ztyosirasemongon25 = pZtyosirasemongon25;
    }

    private String ztyosirasemongon26;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON26)
    public String getZtyosirasemongon26() {
        return ztyosirasemongon26;
    }

    public void setZtyosirasemongon26(String pZtyosirasemongon26) {
        ztyosirasemongon26 = pZtyosirasemongon26;
    }

    private String ztyosirasemongon27;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON27)
    public String getZtyosirasemongon27() {
        return ztyosirasemongon27;
    }

    public void setZtyosirasemongon27(String pZtyosirasemongon27) {
        ztyosirasemongon27 = pZtyosirasemongon27;
    }

    private String ztyosirasemongon28;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON28)
    public String getZtyosirasemongon28() {
        return ztyosirasemongon28;
    }

    public void setZtyosirasemongon28(String pZtyosirasemongon28) {
        ztyosirasemongon28 = pZtyosirasemongon28;
    }

    private String ztyosirasemongon29;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON29)
    public String getZtyosirasemongon29() {
        return ztyosirasemongon29;
    }

    public void setZtyosirasemongon29(String pZtyosirasemongon29) {
        ztyosirasemongon29 = pZtyosirasemongon29;
    }

    private String ztyosirasemongon30;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON30)
    public String getZtyosirasemongon30() {
        return ztyosirasemongon30;
    }

    public void setZtyosirasemongon30(String pZtyosirasemongon30) {
        ztyosirasemongon30 = pZtyosirasemongon30;
    }

    private String ztyosirasemongon31;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON31)
    public String getZtyosirasemongon31() {
        return ztyosirasemongon31;
    }

    public void setZtyosirasemongon31(String pZtyosirasemongon31) {
        ztyosirasemongon31 = pZtyosirasemongon31;
    }

    private String ztyosirasemongon32;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON32)
    public String getZtyosirasemongon32() {
        return ztyosirasemongon32;
    }

    public void setZtyosirasemongon32(String pZtyosirasemongon32) {
        ztyosirasemongon32 = pZtyosirasemongon32;
    }

    private String ztyosirasemongon33;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON33)
    public String getZtyosirasemongon33() {
        return ztyosirasemongon33;
    }

    public void setZtyosirasemongon33(String pZtyosirasemongon33) {
        ztyosirasemongon33 = pZtyosirasemongon33;
    }

    private String ztyosirasemongon34;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON34)
    public String getZtyosirasemongon34() {
        return ztyosirasemongon34;
    }

    public void setZtyosirasemongon34(String pZtyosirasemongon34) {
        ztyosirasemongon34 = pZtyosirasemongon34;
    }

    private String ztyosirasemongon35;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON35)
    public String getZtyosirasemongon35() {
        return ztyosirasemongon35;
    }

    public void setZtyosirasemongon35(String pZtyosirasemongon35) {
        ztyosirasemongon35 = pZtyosirasemongon35;
    }

    private String ztyosirasemongon36;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON36)
    public String getZtyosirasemongon36() {
        return ztyosirasemongon36;
    }

    public void setZtyosirasemongon36(String pZtyosirasemongon36) {
        ztyosirasemongon36 = pZtyosirasemongon36;
    }

    private String ztyosirasemongon37;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON37)
    public String getZtyosirasemongon37() {
        return ztyosirasemongon37;
    }

    public void setZtyosirasemongon37(String pZtyosirasemongon37) {
        ztyosirasemongon37 = pZtyosirasemongon37;
    }

    private String ztyosirasemongon38;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON38)
    public String getZtyosirasemongon38() {
        return ztyosirasemongon38;
    }

    public void setZtyosirasemongon38(String pZtyosirasemongon38) {
        ztyosirasemongon38 = pZtyosirasemongon38;
    }

    private String ztyosirasemongon39;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON39)
    public String getZtyosirasemongon39() {
        return ztyosirasemongon39;
    }

    public void setZtyosirasemongon39(String pZtyosirasemongon39) {
        ztyosirasemongon39 = pZtyosirasemongon39;
    }

    private String ztyosirasemongon40;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON40)
    public String getZtyosirasemongon40() {
        return ztyosirasemongon40;
    }

    public void setZtyosirasemongon40(String pZtyosirasemongon40) {
        ztyosirasemongon40 = pZtyosirasemongon40;
    }

    private String ztyosirasemongon41;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON41)
    public String getZtyosirasemongon41() {
        return ztyosirasemongon41;
    }

    public void setZtyosirasemongon41(String pZtyosirasemongon41) {
        ztyosirasemongon41 = pZtyosirasemongon41;
    }

    private String ztyosirasemongon42;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON42)
    public String getZtyosirasemongon42() {
        return ztyosirasemongon42;
    }

    public void setZtyosirasemongon42(String pZtyosirasemongon42) {
        ztyosirasemongon42 = pZtyosirasemongon42;
    }

    private String ztyosirasemongon43;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON43)
    public String getZtyosirasemongon43() {
        return ztyosirasemongon43;
    }

    public void setZtyosirasemongon43(String pZtyosirasemongon43) {
        ztyosirasemongon43 = pZtyosirasemongon43;
    }

    private String ztyosirasemongon44;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON44)
    public String getZtyosirasemongon44() {
        return ztyosirasemongon44;
    }

    public void setZtyosirasemongon44(String pZtyosirasemongon44) {
        ztyosirasemongon44 = pZtyosirasemongon44;
    }

    private String ztyosirasemongon45;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON45)
    public String getZtyosirasemongon45() {
        return ztyosirasemongon45;
    }

    public void setZtyosirasemongon45(String pZtyosirasemongon45) {
        ztyosirasemongon45 = pZtyosirasemongon45;
    }

    private String ztyosirasemongon46;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON46)
    public String getZtyosirasemongon46() {
        return ztyosirasemongon46;
    }

    public void setZtyosirasemongon46(String pZtyosirasemongon46) {
        ztyosirasemongon46 = pZtyosirasemongon46;
    }

    private String ztyosirasemongon47;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON47)
    public String getZtyosirasemongon47() {
        return ztyosirasemongon47;
    }

    public void setZtyosirasemongon47(String pZtyosirasemongon47) {
        ztyosirasemongon47 = pZtyosirasemongon47;
    }

    private String ztyosirasemongon48;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON48)
    public String getZtyosirasemongon48() {
        return ztyosirasemongon48;
    }

    public void setZtyosirasemongon48(String pZtyosirasemongon48) {
        ztyosirasemongon48 = pZtyosirasemongon48;
    }

    private String ztyosirasemongon49;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON49)
    public String getZtyosirasemongon49() {
        return ztyosirasemongon49;
    }

    public void setZtyosirasemongon49(String pZtyosirasemongon49) {
        ztyosirasemongon49 = pZtyosirasemongon49;
    }

    private String ztyosirasemongon50;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYOSIRASEMONGON50)
    public String getZtyosirasemongon50() {
        return ztyosirasemongon50;
    }

    public void setZtyosirasemongon50(String pZtyosirasemongon50) {
        ztyosirasemongon50 = pZtyosirasemongon50;
    }

    private String ztyyobiv255;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV255)
    public String getZtyyobiv255() {
        return ztyyobiv255;
    }

    public void setZtyyobiv255(String pZtyyobiv255) {
        ztyyobiv255 = pZtyyobiv255;
    }

    private String ztyansyuyouyobin10x10;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X10)
    public String getZtyansyuyouyobin10x10() {
        return ztyansyuyouyobin10x10;
    }

    public void setZtyansyuyouyobin10x10(String pZtyansyuyouyobin10x10) {
        ztyansyuyouyobin10x10 = pZtyansyuyouyobin10x10;
    }

    private String ztyteisyutusrmongon1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEISYUTUSRMONGON1)
    public String getZtyteisyutusrmongon1() {
        return ztyteisyutusrmongon1;
    }

    public void setZtyteisyutusrmongon1(String pZtyteisyutusrmongon1) {
        ztyteisyutusrmongon1 = pZtyteisyutusrmongon1;
    }

    private String ztyteisyutusrmongon2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEISYUTUSRMONGON2)
    public String getZtyteisyutusrmongon2() {
        return ztyteisyutusrmongon2;
    }

    public void setZtyteisyutusrmongon2(String pZtyteisyutusrmongon2) {
        ztyteisyutusrmongon2 = pZtyteisyutusrmongon2;
    }

    private String ztyteisyutusrmongon3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEISYUTUSRMONGON3)
    public String getZtyteisyutusrmongon3() {
        return ztyteisyutusrmongon3;
    }

    public void setZtyteisyutusrmongon3(String pZtyteisyutusrmongon3) {
        ztyteisyutusrmongon3 = pZtyteisyutusrmongon3;
    }

    private String ztymsgyobi1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYMSGYOBI1)
    public String getZtymsgyobi1() {
        return ztymsgyobi1;
    }

    public void setZtymsgyobi1(String pZtymsgyobi1) {
        ztymsgyobi1 = pZtymsgyobi1;
    }

    private String ztyansyuyouyobin10x11;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X11)
    public String getZtyansyuyouyobin10x11() {
        return ztyansyuyouyobin10x11;
    }

    public void setZtyansyuyouyobin10x11(String pZtyansyuyouyobin10x11) {
        ztyansyuyouyobin10x11 = pZtyansyuyouyobin10x11;
    }

    private String ztyseikyuusyasyomeimongon1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYASYOMEIMONGON1)
    public String getZtyseikyuusyasyomeimongon1() {
        return ztyseikyuusyasyomeimongon1;
    }

    public void setZtyseikyuusyasyomeimongon1(String pZtyseikyuusyasyomeimongon1) {
        ztyseikyuusyasyomeimongon1 = pZtyseikyuusyasyomeimongon1;
    }

    private String ztyseikyuusyasyomeimongon2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYASYOMEIMONGON2)
    public String getZtyseikyuusyasyomeimongon2() {
        return ztyseikyuusyasyomeimongon2;
    }

    public void setZtyseikyuusyasyomeimongon2(String pZtyseikyuusyasyomeimongon2) {
        ztyseikyuusyasyomeimongon2 = pZtyseikyuusyasyomeimongon2;
    }

    private String ztyseikyuusyasyomeimongon3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYASYOMEIMONGON3)
    public String getZtyseikyuusyasyomeimongon3() {
        return ztyseikyuusyasyomeimongon3;
    }

    public void setZtyseikyuusyasyomeimongon3(String pZtyseikyuusyasyomeimongon3) {
        ztyseikyuusyasyomeimongon3 = pZtyseikyuusyasyomeimongon3;
    }

    private String ztyseikyuusyasyomeimongon4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYASYOMEIMONGON4)
    public String getZtyseikyuusyasyomeimongon4() {
        return ztyseikyuusyasyomeimongon4;
    }

    public void setZtyseikyuusyasyomeimongon4(String pZtyseikyuusyasyomeimongon4) {
        ztyseikyuusyasyomeimongon4 = pZtyseikyuusyasyomeimongon4;
    }

    private String ztyseikyuusyasyomeimongon5;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYASYOMEIMONGON5)
    public String getZtyseikyuusyasyomeimongon5() {
        return ztyseikyuusyasyomeimongon5;
    }

    public void setZtyseikyuusyasyomeimongon5(String pZtyseikyuusyasyomeimongon5) {
        ztyseikyuusyasyomeimongon5 = pZtyseikyuusyasyomeimongon5;
    }

    private String ztyseikyuusyasyomeimongon6;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYASYOMEIMONGON6)
    public String getZtyseikyuusyasyomeimongon6() {
        return ztyseikyuusyasyomeimongon6;
    }

    public void setZtyseikyuusyasyomeimongon6(String pZtyseikyuusyasyomeimongon6) {
        ztyseikyuusyasyomeimongon6 = pZtyseikyuusyasyomeimongon6;
    }

    private String ztyseikyuusyasyomeimongon7;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYASYOMEIMONGON7)
    public String getZtyseikyuusyasyomeimongon7() {
        return ztyseikyuusyasyomeimongon7;
    }

    public void setZtyseikyuusyasyomeimongon7(String pZtyseikyuusyasyomeimongon7) {
        ztyseikyuusyasyomeimongon7 = pZtyseikyuusyasyomeimongon7;
    }

    private String ztyseikyuusyasyomeimongon8;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYASYOMEIMONGON8)
    public String getZtyseikyuusyasyomeimongon8() {
        return ztyseikyuusyasyomeimongon8;
    }

    public void setZtyseikyuusyasyomeimongon8(String pZtyseikyuusyasyomeimongon8) {
        ztyseikyuusyasyomeimongon8 = pZtyseikyuusyasyomeimongon8;
    }

    private String ztyseikyuusyasyomeimongon9;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYASYOMEIMONGON9)
    public String getZtyseikyuusyasyomeimongon9() {
        return ztyseikyuusyasyomeimongon9;
    }

    public void setZtyseikyuusyasyomeimongon9(String pZtyseikyuusyasyomeimongon9) {
        ztyseikyuusyasyomeimongon9 = pZtyseikyuusyasyomeimongon9;
    }

    private String ztyseikyuusyagenyno;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYAGENYNO)
    public String getZtyseikyuusyagenyno() {
        return ztyseikyuusyagenyno;
    }

    public void setZtyseikyuusyagenyno(String pZtyseikyuusyagenyno) {
        ztyseikyuusyagenyno = pZtyseikyuusyagenyno;
    }

    private String ztyseikyuusyagenadr1;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYAGENADR1)
    public String getZtyseikyuusyagenadr1() {
        return ztyseikyuusyagenadr1;
    }

    public void setZtyseikyuusyagenadr1(String pZtyseikyuusyagenadr1) {
        ztyseikyuusyagenadr1 = pZtyseikyuusyagenadr1;
    }

    private String ztyseikyuusyagenadr2;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYAGENADR2)
    public String getZtyseikyuusyagenadr2() {
        return ztyseikyuusyagenadr2;
    }

    public void setZtyseikyuusyagenadr2(String pZtyseikyuusyagenadr2) {
        ztyseikyuusyagenadr2 = pZtyseikyuusyagenadr2;
    }

    private String ztyseikyuusyagenadr3;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUSYAGENADR3)
    public String getZtyseikyuusyagenadr3() {
        return ztyseikyuusyagenadr3;
    }

    public void setZtyseikyuusyagenadr3(String pZtyseikyuusyagenadr3) {
        ztyseikyuusyagenadr3 = pZtyseikyuusyagenadr3;
    }

    private String ztyseikyuuyagentelno;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYSEIKYUUYAGENTELNO)
    public String getZtyseikyuuyagentelno() {
        return ztyseikyuuyagentelno;
    }

    public void setZtyseikyuuyagentelno(String pZtyseikyuuyagentelno) {
        ztyseikyuuyagentelno = pZtyseikyuuyagentelno;
    }

    private String ztytoritugisyasyozokunm;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTORITUGISYASYOZOKUNM)
    public String getZtytoritugisyasyozokunm() {
        return ztytoritugisyasyozokunm;
    }

    public void setZtytoritugisyasyozokunm(String pZtytoritugisyasyozokunm) {
        ztytoritugisyasyozokunm = pZtytoritugisyasyozokunm;
    }

    private String ztytoritugisyakjncd;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTORITUGISYAKJNCD)
    public String getZtytoritugisyakjncd() {
        return ztytoritugisyakjncd;
    }

    public void setZtytoritugisyakjncd(String pZtytoritugisyakjncd) {
        ztytoritugisyakjncd = pZtytoritugisyakjncd;
    }

    private String ztytoritugisyanm;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTORITUGISYANM)
    public String getZtytoritugisyanm() {
        return ztytoritugisyanm;
    }

    public void setZtytoritugisyanm(String pZtytoritugisyanm) {
        ztytoritugisyanm = pZtytoritugisyanm;
    }

    private String ztyhozonkkny;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYHOZONKKNY)
    public String getZtyhozonkkny() {
        return ztyhozonkkny;
    }

    public void setZtyhozonkkny(String pZtyhozonkkny) {
        ztyhozonkkny = pZtyhozonkkny;
    }

    private String ztyyobiv168;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV168)
    public String getZtyyobiv168() {
        return ztyyobiv168;
    }

    public void setZtyyobiv168(String pZtyyobiv168) {
        ztyyobiv168 = pZtyyobiv168;
    }

    private String ztyansyuyouyobin10x12;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYANSYUYOUYOBIN10X12)
    public String getZtyansyuyouyobin10x12() {
        return ztyansyuyouyobin10x12;
    }

    public void setZtyansyuyouyobin10x12(String pZtyansyuyouyobin10x12) {
        ztyansyuyouyobin10x12 = pZtyansyuyouyobin10x12;
    }

    private String ztyteisyutusrmongon4;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYTEISYUTUSRMONGON4)
    public String getZtyteisyutusrmongon4() {
        return ztyteisyutusrmongon4;
    }

    public void setZtyteisyutusrmongon4(String pZtyteisyutusrmongon4) {
        ztyteisyutusrmongon4 = pZtyteisyutusrmongon4;
    }

    private String ztyyobiv155;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV155)
    public String getZtyyobiv155() {
        return ztyyobiv155;
    }

    public void setZtyyobiv155(String pZtyyobiv155) {
        ztyyobiv155 = pZtyyobiv155;
    }

    private String ztyyobiv97;

    @Column(name=GenZT_SyoumetuTuutiTy.ZTYYOBIV97)
    public String getZtyyobiv97() {
        return ztyyobiv97;
    }

    public void setZtyyobiv97(String pZtyyobiv97) {
        ztyyobiv97 = pZtyyobiv97;
    }
}