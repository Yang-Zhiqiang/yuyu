CREATE VIEW ZT_SiShrdetailRn AS SELECT
     zrnsyoruicd ,         /* （連携用）書類コード */
     zrntyouhyouymd ,         /* （連携用）帳票作成日 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnhassoukbn ,         /* （連携用）発送区分 */
     zrnsyodouhuukbn ,         /* （連携用）証券同封区分 */
     zrnsikibetuno ,         /* （連携用）識別番号 */
     zrnsikytkmkyobi1 ,         /* （連携用）保険金共通項目予備１ */
     zrnshskyno ,         /* （連携用）送付先郵便番号 */
     zrnshskadr1kj ,         /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj ,         /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj ,         /* （連携用）送付先住所３（漢字） */
     zrnshsnmkjsimisi ,         /* （連携用）送付先名（漢字）（支払明細） */
     zrnsimisituutimei ,         /* （連携用）支払明細書通知名 */
     zrnsimisiosirasemongon1x1 ,         /* （連携用）支払明細書お知らせ文言１－１ */
     zrnsimisiosirasemongon1x2 ,         /* （連携用）支払明細書お知らせ文言１－２ */
     zrnsimisiosirasemongon2x1 ,         /* （連携用）支払明細書お知らせ文言２－１ */
     zrnsimisiosirasemongon2x2 ,         /* （連携用）支払明細書お知らせ文言２－２ */
     zrnsimisiosirasemongon2x3 ,         /* （連携用）支払明細書お知らせ文言２－３ */
     zrnsimisiosirasemongon2x4 ,         /* （連携用）支払明細書お知らせ文言２－４ */
     zrnsimisiosirasemongon2x5 ,         /* （連携用）支払明細書お知らせ文言２－５ */
     zrntawyno ,         /* （連携用）問合せ先郵便番号 */
     zrntawadr1kj30 ,         /* （連携用）問合せ先住所１（漢字３０桁） */
     zrntawadr2kj30 ,         /* （連携用）問合せ先住所２（漢字３０桁） */
     zrntawadr3kj30 ,         /* （連携用）問合せ先住所３（漢字３０桁） */
     zrntawtelno ,         /* （連携用）問合せ先電話番号 */
     zrnsimisiatenabuyobi1 ,         /* （連携用）支払明細書宛名部予備１ */
     zrnsimisiatenabuyobi2 ,         /* （連携用）支払明細書宛名部予備２ */
     zrnsyono2 ,         /* （連携用）証券番号２ */
     zrnkyknmkj ,         /* （連携用）契約者名（漢字） */
     zrnhhknnmkj ,         /* （連携用）被保険者名（漢字） */
     zrntyouhyouymdwa ,         /* （連携用）帳票作成日（和暦） */
     zrnsiharaibiwareki ,         /* （連携用）支払日（和暦） */
     zrnbanknmkj ,         /* （連携用）銀行名（漢字） */
     zrnsitennmkj ,         /* （連携用）支店名（漢字） */
     zrnyokinsyumokumeikanji ,         /* （連携用）預金種目名（漢字） */
     zrnkouzano12keta ,         /* （連携用）口座番号（１２桁） */
     zrnkzmeiginmkn ,         /* （連携用）口座名義人氏名（カナ） */
     zrnkouzamaskingmsg ,         /* （連携用）口座マスキングＭＳＧ */
     zrnsimisisummarybuyobi1 ,         /* （連携用）支払明細書サマリー部予備１ */
     zrnsimisisummarybuyobi2 ,         /* （連携用）支払明細書サマリー部予備２ */
     zrnsimisitekiyouranmidasi ,         /* （連携用）支払明細書摘要欄見出し */
     zrnsimisimeisairanmidasi ,         /* （連携用）支払金額明細欄見出し */
     zrnsimisibikouranmidasi ,         /* （連携用）支払明細書備考欄見出し */
     zrnsimisimeisaibumidasiyobi ,         /* （連携用）支払明細書明細部見出し予備 */
     zrnsimisitekiyou1 ,         /* （連携用）支払明細書摘要１ */
     zrnsimisikngkmisi1 ,         /* （連携用）支払明細書金額明細１ */
     zrnsimisikngkmisituukasyu1 ,         /* （連携用）支払明細書金額明細通貨種類１ */
     zrnsimisimeisaibikou1 ,         /* （連携用）支払明細書明細備考１ */
     zrnsimisikngkmisihugou1 ,         /* （連携用）支払明細書金額明細符号１ */
     zrnsimisimeisaiyobi1 ,         /* （連携用）支払明細書明細予備１ */
     zrnsimisitekiyou2 ,         /* （連携用）支払明細書摘要２ */
     zrnsimisikngkmisi2 ,         /* （連携用）支払明細書金額明細２ */
     zrnsimisikngkmisituukasyu2 ,         /* （連携用）支払明細書金額明細通貨種類２ */
     zrnsimisimeisaibikou2 ,         /* （連携用）支払明細書明細備考２ */
     zrnsimisikngkmisihugou2 ,         /* （連携用）支払明細書金額明細符号２ */
     zrnsimisimeisaiyobi2 ,         /* （連携用）支払明細書明細予備２ */
     zrnsimisitekiyou3 ,         /* （連携用）支払明細書摘要３ */
     zrnsimisikngkmisi3 ,         /* （連携用）支払明細書金額明細３ */
     zrnsimisikngkmisituukasyu3 ,         /* （連携用）支払明細書金額明細通貨種類３ */
     zrnsimisimeisaibikou3 ,         /* （連携用）支払明細書明細備考３ */
     zrnsimisikngkmisihugou3 ,         /* （連携用）支払明細書金額明細符号３ */
     zrnsimisimeisaiyobi3 ,         /* （連携用）支払明細書明細予備３ */
     zrnsimisitekiyou4 ,         /* （連携用）支払明細書摘要４ */
     zrnsimisikngkmisi4 ,         /* （連携用）支払明細書金額明細４ */
     zrnsimisikngkmisituukasyu4 ,         /* （連携用）支払明細書金額明細通貨種類４ */
     zrnsimisimeisaibikou4 ,         /* （連携用）支払明細書明細備考４ */
     zrnsimisikngkmisihugou4 ,         /* （連携用）支払明細書金額明細符号４ */
     zrnsimisimeisaiyobi4 ,         /* （連携用）支払明細書明細予備４ */
     zrnsimisitekiyou5 ,         /* （連携用）支払明細書摘要５ */
     zrnsimisikngkmisi5 ,         /* （連携用）支払明細書金額明細５ */
     zrnsimisikngkmisituukasyu5 ,         /* （連携用）支払明細書金額明細通貨種類５ */
     zrnsimisimeisaibikou5 ,         /* （連携用）支払明細書明細備考５ */
     zrnsimisikngkmisihugou5 ,         /* （連携用）支払明細書金額明細符号５ */
     zrnsimisimeisaiyobi5 ,         /* （連携用）支払明細書明細予備５ */
     zrnsimisitekiyou6 ,         /* （連携用）支払明細書摘要６ */
     zrnsimisikngkmisi6 ,         /* （連携用）支払明細書金額明細６ */
     zrnsimisikngkmisituukasyu6 ,         /* （連携用）支払明細書金額明細通貨種類６ */
     zrnsimisimeisaibikou6 ,         /* （連携用）支払明細書明細備考６ */
     zrnsimisikngkmisihugou6 ,         /* （連携用）支払明細書金額明細符号６ */
     zrnsimisimeisaiyobi6 ,         /* （連携用）支払明細書明細予備６ */
     zrnsimisitekiyou7 ,         /* （連携用）支払明細書摘要７ */
     zrnsimisikngkmisi7 ,         /* （連携用）支払明細書金額明細７ */
     zrnsimisikngkmisituukasyu7 ,         /* （連携用）支払明細書金額明細通貨種類７ */
     zrnsimisimeisaibikou7 ,         /* （連携用）支払明細書明細備考７ */
     zrnsimisikngkmisihugou7 ,         /* （連携用）支払明細書金額明細符号７ */
     zrnsimisimeisaiyobi7 ,         /* （連携用）支払明細書明細予備７ */
     zrnsimisitekiyou8 ,         /* （連携用）支払明細書摘要８ */
     zrnsimisikngkmisi8 ,         /* （連携用）支払明細書金額明細８ */
     zrnsimisikngkmisituukasyu8 ,         /* （連携用）支払明細書金額明細通貨種類８ */
     zrnsimisimeisaibikou8 ,         /* （連携用）支払明細書明細備考８ */
     zrnsimisikngkmisihugou8 ,         /* （連携用）支払明細書金額明細符号８ */
     zrnsimisimeisaiyobi8 ,         /* （連携用）支払明細書明細予備８ */
     zrnsimisitekiyou9 ,         /* （連携用）支払明細書摘要９ */
     zrnsimisikngkmisi9 ,         /* （連携用）支払明細書金額明細９ */
     zrnsimisikngkmisituukasyu9 ,         /* （連携用）支払明細書金額明細通貨種類９ */
     zrnsimisimeisaibikou9 ,         /* （連携用）支払明細書明細備考９ */
     zrnsimisikngkmisihugou9 ,         /* （連携用）支払明細書金額明細符号９ */
     zrnsimisimeisaiyobi9 ,         /* （連携用）支払明細書明細予備９ */
     zrnsimisitekiyou10 ,         /* （連携用）支払明細書摘要１０ */
     zrnsimisikngkmisi10 ,         /* （連携用）支払明細書金額明細１０ */
     zrnsimisikngkmisituukasyu10 ,         /* （連携用）支払明細書金額明細通貨種類１０ */
     zrnsimisimeisaibikou10 ,         /* （連携用）支払明細書明細備考１０ */
     zrnsimisikngkmisihugou10 ,         /* （連携用）支払明細書金額明細符号１０ */
     zrnsimisimeisaiyobi10 ,         /* （連携用）支払明細書明細予備１０ */
     zrnsimisitekiyou11 ,         /* （連携用）支払明細書摘要１１ */
     zrnsimisikngkmisi11 ,         /* （連携用）支払明細書金額明細１１ */
     zrnsimisikngkmisituukasyu11 ,         /* （連携用）支払明細書金額明細通貨種類１１ */
     zrnsimisimeisaibikou11 ,         /* （連携用）支払明細書明細備考１１ */
     zrnsimisikngkmisihugou11 ,         /* （連携用）支払明細書金額明細符号１１ */
     zrnsimisimeisaiyobi11 ,         /* （連携用）支払明細書明細予備１１ */
     zrnsimisitekiyou12 ,         /* （連携用）支払明細書摘要１２ */
     zrnsimisikngkmisi12 ,         /* （連携用）支払明細書金額明細１２ */
     zrnsimisikngkmisituukasyu12 ,         /* （連携用）支払明細書金額明細通貨種類１２ */
     zrnsimisimeisaibikou12 ,         /* （連携用）支払明細書明細備考１２ */
     zrnsimisikngkmisihugou12 ,         /* （連携用）支払明細書金額明細符号１２ */
     zrnsimisimeisaiyobi12 ,         /* （連携用）支払明細書明細予備１２ */
     zrnsimisitekiyou13 ,         /* （連携用）支払明細書摘要１３ */
     zrnsimisikngkmisi13 ,         /* （連携用）支払明細書金額明細１３ */
     zrnsimisikngkmisituukasyu13 ,         /* （連携用）支払明細書金額明細通貨種類１３ */
     zrnsimisimeisaibikou13 ,         /* （連携用）支払明細書明細備考１３ */
     zrnsimisikngkmisihugou13 ,         /* （連携用）支払明細書金額明細符号１３ */
     zrnsimisimeisaiyobi13 ,         /* （連携用）支払明細書明細予備１３ */
     zrnsimisitekiyou14 ,         /* （連携用）支払明細書摘要１４ */
     zrnsimisikngkmisi14 ,         /* （連携用）支払明細書金額明細１４ */
     zrnsimisikngkmisituukasyu14 ,         /* （連携用）支払明細書金額明細通貨種類１４ */
     zrnsimisimeisaibikou14 ,         /* （連携用）支払明細書明細備考１４ */
     zrnsimisikngkmisihugou14 ,         /* （連携用）支払明細書金額明細符号１４ */
     zrnsimisimeisaiyobi14 ,         /* （連携用）支払明細書明細予備１４ */
     zrnsimisitekiyou15 ,         /* （連携用）支払明細書摘要１５ */
     zrnsimisikngkmisi15 ,         /* （連携用）支払明細書金額明細１５ */
     zrnsimisikngkmisituukasyu15 ,         /* （連携用）支払明細書金額明細通貨種類１５ */
     zrnsimisimeisaibikou15 ,         /* （連携用）支払明細書明細備考１５ */
     zrnsimisikngkmisihugou15 ,         /* （連携用）支払明細書金額明細符号１５ */
     zrnsimisimeisaiyobi15 ,         /* （連携用）支払明細書明細予備１５ */
     zrnsimisitekiyou16 ,         /* （連携用）支払明細書摘要１６ */
     zrnsimisikngkmisi16 ,         /* （連携用）支払明細書金額明細１６ */
     zrnsimisikngkmisituukasyu16 ,         /* （連携用）支払明細書金額明細通貨種類１６ */
     zrnsimisimeisaibikou16 ,         /* （連携用）支払明細書明細備考１６ */
     zrnsimisikngkmisihugou16 ,         /* （連携用）支払明細書金額明細符号１６ */
     zrnsimisimeisaiyobi16 ,         /* （連携用）支払明細書明細予備１６ */
     zrnsimisitekiyou17 ,         /* （連携用）支払明細書摘要１７ */
     zrnsimisikngkmisi17 ,         /* （連携用）支払明細書金額明細１７ */
     zrnsimisikngkmisituukasyu17 ,         /* （連携用）支払明細書金額明細通貨種類１７ */
     zrnsimisimeisaibikou17 ,         /* （連携用）支払明細書明細備考１７ */
     zrnsimisikngkmisihugou17 ,         /* （連携用）支払明細書金額明細符号１７ */
     zrnsimisimeisaiyobi17 ,         /* （連携用）支払明細書明細予備１７ */
     zrnsimisitekiyou18 ,         /* （連携用）支払明細書摘要１８ */
     zrnsimisikngkmisi18 ,         /* （連携用）支払明細書金額明細１８ */
     zrnsimisikngkmisituukasyu18 ,         /* （連携用）支払明細書金額明細通貨種類１８ */
     zrnsimisimeisaibikou18 ,         /* （連携用）支払明細書明細備考１８ */
     zrnsimisikngkmisihugou18 ,         /* （連携用）支払明細書金額明細符号１８ */
     zrnsimisimeisaiyobi18 ,         /* （連携用）支払明細書明細予備１８ */
     zrnsimisitekiyou19 ,         /* （連携用）支払明細書摘要１９ */
     zrnsimisikngkmisi19 ,         /* （連携用）支払明細書金額明細１９ */
     zrnsimisikngkmisituukasyu19 ,         /* （連携用）支払明細書金額明細通貨種類１９ */
     zrnsimisimeisaibikou19 ,         /* （連携用）支払明細書明細備考１９ */
     zrnsimisikngkmisihugou19 ,         /* （連携用）支払明細書金額明細符号１９ */
     zrnsimisimeisaiyobi19 ,         /* （連携用）支払明細書明細予備１９ */
     zrnsimisitekiyou20 ,         /* （連携用）支払明細書摘要２０ */
     zrnsimisikngkmisi20 ,         /* （連携用）支払明細書金額明細２０ */
     zrnsimisikngkmisituukasyu20 ,         /* （連携用）支払明細書金額明細通貨種類２０ */
     zrnsimisimeisaibikou20 ,         /* （連携用）支払明細書明細備考２０ */
     zrnsimisikngkmisihugou20 ,         /* （連携用）支払明細書金額明細符号２０ */
     zrnsimisimeisaiyobi20 ,         /* （連携用）支払明細書明細予備２０ */
     zrnsimisitekiyou21 ,         /* （連携用）支払明細書摘要２１ */
     zrnsimisikngkmisi21 ,         /* （連携用）支払明細書金額明細２１ */
     zrnsimisikngkmisituukasyu21 ,         /* （連携用）支払明細書金額明細通貨種類２１ */
     zrnsimisimeisaibikou21 ,         /* （連携用）支払明細書明細備考２１ */
     zrnsimisikngkmisihugou21 ,         /* （連携用）支払明細書金額明細符号２１ */
     zrnsimisimeisaiyobi21 ,         /* （連携用）支払明細書明細予備２１ */
     zrnsimisitekiyou22 ,         /* （連携用）支払明細書摘要２２ */
     zrnsimisikngkmisi22 ,         /* （連携用）支払明細書金額明細２２ */
     zrnsimisikngkmisituukasyu22 ,         /* （連携用）支払明細書金額明細通貨種類２２ */
     zrnsimisimeisaibikou22 ,         /* （連携用）支払明細書明細備考２２ */
     zrnsimisikngkmisihugou22 ,         /* （連携用）支払明細書金額明細符号２２ */
     zrnsimisimeisaiyobi22 ,         /* （連携用）支払明細書明細予備２２ */
     zrnsimisitekiyou23 ,         /* （連携用）支払明細書摘要２３ */
     zrnsimisikngkmisi23 ,         /* （連携用）支払明細書金額明細２３ */
     zrnsimisikngkmisituukasyu23 ,         /* （連携用）支払明細書金額明細通貨種類２３ */
     zrnsimisimeisaibikou23 ,         /* （連携用）支払明細書明細備考２３ */
     zrnsimisikngkmisihugou23 ,         /* （連携用）支払明細書金額明細符号２３ */
     zrnsimisimeisaiyobi23 ,         /* （連携用）支払明細書明細予備２３ */
     zrnsimisitekiyou24 ,         /* （連携用）支払明細書摘要２４ */
     zrnsimisikngkmisi24 ,         /* （連携用）支払明細書金額明細２４ */
     zrnsimisikngkmisituukasyu24 ,         /* （連携用）支払明細書金額明細通貨種類２４ */
     zrnsimisimeisaibikou24 ,         /* （連携用）支払明細書明細備考２４ */
     zrnsimisikngkmisihugou24 ,         /* （連携用）支払明細書金額明細符号２４ */
     zrnsimisimeisaiyobi24 ,         /* （連携用）支払明細書明細予備２４ */
     zrnsimisitekiyou25 ,         /* （連携用）支払明細書摘要２５ */
     zrnsimisikngkmisi25 ,         /* （連携用）支払明細書金額明細２５ */
     zrnsimisikngkmisituukasyu25 ,         /* （連携用）支払明細書金額明細通貨種類２５ */
     zrnsimisimeisaibikou25 ,         /* （連携用）支払明細書明細備考２５ */
     zrnsimisikngkmisihugou25 ,         /* （連携用）支払明細書金額明細符号２５ */
     zrnsimisimeisaiyobi25 ,         /* （連携用）支払明細書明細予備２５ */
     zrnsimisimeisaibuyobi1x1 ,         /* （連携用）支払明細書明細部予備１－１ */
     zrnsimisimeisaibuyobi1x2 ,         /* （連携用）支払明細書明細部予備１－２ */
     zrnsimisimeisaibuyobi1x3 ,         /* （連携用）支払明細書明細部予備１－３ */
     zrnsimisimeisaibuyobi1x4 ,         /* （連携用）支払明細書明細部予備１－４ */
     zrnsimisimeisaibuyobi1x5 ,         /* （連携用）支払明細書明細部予備１－５ */
     zrnsimisimeisaibuyobi1x6 ,         /* （連携用）支払明細書明細部予備１－６ */
     zrnsimisisigoukeikingaku ,         /* （連携用）支払明細書支払合計金額 */
     zrnsimisisigoukeituukasyu ,         /* （連携用）支払明細書支払合計通貨種類 */
     zrnsimisimeisaibuyobi2 ,         /* （連携用）支払明細書明細部予備２ */
     zrnsimisituutiranmidasi ,         /* （連携用）支払明細書通知欄見出し */
     zrnsimisifreemsg1 ,         /* （連携用）支払明細書フリーメッセージ１ */
     zrnsimisifreemsg2 ,         /* （連携用）支払明細書フリーメッセージ２ */
     zrnsimisifreemsg3 ,         /* （連携用）支払明細書フリーメッセージ３ */
     zrnsimisifreemsg4 ,         /* （連携用）支払明細書フリーメッセージ４ */
     zrnsimisifreemsg5 ,         /* （連携用）支払明細書フリーメッセージ５ */
     zrnsimisifreemsg6 ,         /* （連携用）支払明細書フリーメッセージ６ */
     zrnsimisifreemsg7 ,         /* （連携用）支払明細書フリーメッセージ７ */
     zrnsimisifreemsg8 ,         /* （連携用）支払明細書フリーメッセージ８ */
     zrnsimisifreemsg9 ,         /* （連携用）支払明細書フリーメッセージ９ */
     zrnsimisifreemsg10 ,         /* （連携用）支払明細書フリーメッセージ１０ */
     zrnsimisifreemsg11 ,         /* （連携用）支払明細書フリーメッセージ１１ */
     zrnsimisifreemsg12 ,         /* （連携用）支払明細書フリーメッセージ１２ */
     zrnsimisifreemsg13 ,         /* （連携用）支払明細書フリーメッセージ１３ */
     zrnsimisifreemsg14 ,         /* （連携用）支払明細書フリーメッセージ１４ */
     zrnsimisifreemsg15 ,         /* （連携用）支払明細書フリーメッセージ１５ */
     zrnsimisifreemsg16 ,         /* （連携用）支払明細書フリーメッセージ１６ */
     zrnsimisifreemsg17 ,         /* （連携用）支払明細書フリーメッセージ１７ */
     zrnsimisifreemsg18 ,         /* （連携用）支払明細書フリーメッセージ１８ */
     zrnsimisifreemsg19 ,         /* （連携用）支払明細書フリーメッセージ１９ */
     zrnsimisifreemsg20 ,         /* （連携用）支払明細書フリーメッセージ２０ */
     zrnsimisifreemsg21 ,         /* （連携用）支払明細書フリーメッセージ２１ */
     zrnsimisifreemsg22 ,         /* （連携用）支払明細書フリーメッセージ２２ */
     zrnsimisifreemsg23 ,         /* （連携用）支払明細書フリーメッセージ２３ */
     zrnsimisifreemsg24 ,         /* （連携用）支払明細書フリーメッセージ２４ */
     zrnsimisifreemsg25 ,         /* （連携用）支払明細書フリーメッセージ２５ */
     zrnsimisifreemsg26 ,         /* （連携用）支払明細書フリーメッセージ２６ */
     zrnsimisifreemsg27 ,         /* （連携用）支払明細書フリーメッセージ２７ */
     zrnsimisifreemsg28 ,         /* （連携用）支払明細書フリーメッセージ２８ */
     zrnsimisifreemsg29 ,         /* （連携用）支払明細書フリーメッセージ２９ */
     zrnsimisifreemsg30 ,         /* （連携用）支払明細書フリーメッセージ３０ */
     zrnsimisifreemsg31 ,         /* （連携用）支払明細書フリーメッセージ３１ */
     zrnsimisifreemsg32 ,         /* （連携用）支払明細書フリーメッセージ３２ */
     zrnsimisifreemsg33 ,         /* （連携用）支払明細書フリーメッセージ３３ */
     zrnsimisifreemsg34 ,         /* （連携用）支払明細書フリーメッセージ３４ */
     zrnsimisifreemsg35 ,         /* （連携用）支払明細書フリーメッセージ３５ */
     zrnsimisifreemsg36 ,         /* （連携用）支払明細書フリーメッセージ３６ */
     zrnsimisifreemsg37 ,         /* （連携用）支払明細書フリーメッセージ３７ */
     zrnsimisifreemsg38 ,         /* （連携用）支払明細書フリーメッセージ３８ */
     zrnsimisifreemsg39 ,         /* （連携用）支払明細書フリーメッセージ３９ */
     zrnsimisifreemsg40 ,         /* （連携用）支払明細書フリーメッセージ４０ */
     zrnsimisifreemsg41 ,         /* （連携用）支払明細書フリーメッセージ４１ */
     zrnsimisifreemsg42 ,         /* （連携用）支払明細書フリーメッセージ４２ */
     zrnsimisifreemsg43 ,         /* （連携用）支払明細書フリーメッセージ４３ */
     zrnsimisifreemsg44 ,         /* （連携用）支払明細書フリーメッセージ４４ */
     zrnsimisifreemsg45 ,         /* （連携用）支払明細書フリーメッセージ４５ */
     zrnsimisifreemsg46 ,         /* （連携用）支払明細書フリーメッセージ４６ */
     zrnsimisiosirasemongon3x1 ,         /* （連携用）支払明細書お知らせ文言３－１ */
     zrnsimisiosirasemongon3x2 ,         /* （連携用）支払明細書お知らせ文言３－２ */
     zrnsimisisynykngk ,         /* （連携用）支払明細書収入金額 */
     zrnsimisihtykeihi ,         /* （連携用）支払明細書必要経費 */
     zrnkztkgk ,         /* （連携用）課税対象金額 */
     zrnzeitratkikbn ,         /* （連携用）税取扱区分 */
     zrnkykhenkouumukbn ,         /* （連携用）契約者変更有無区分 */
     zrnshrkykhtykeihi ,         /* （連携用）支払時契約者必要経費 */
     zrnsimisimeisaibuyobi3x1 ,         /* （連携用）支払明細書明細部予備３－１ */
     zrnsimisimeisaibuyobi3x2           /* （連携用）支払明細書明細部予備３－２ */
FROM ZT_SiShrdetailRn_Z;