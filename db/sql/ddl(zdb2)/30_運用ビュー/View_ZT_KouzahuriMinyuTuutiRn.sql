CREATE VIEW ZT_KouzahuriMinyuTuutiRn AS SELECT
     zrnsyoruicd ,         /* （連携用）書類コード */
     zrnhassoukbn ,         /* （連携用）発送区分 */
     zrntyouhyouymd ,         /* （連携用）帳票作成日 */
     zrntyouhyouymdkj ,         /* （連携用）帳票作成日（漢字） */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnyobiv9 ,         /* （連携用）予備項目Ｖ９ */
     zrnansyuyouyobin10 ,         /* （連携用）案内収納用予備項目Ｎ１０ */
     zrnshskyno ,         /* （連携用）送付先郵便番号 */
     zrnshskadr1kj ,         /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj ,         /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj ,         /* （連携用）送付先住所３（漢字） */
     zrnshsnmkj ,         /* （連携用）送付先名（漢字） */
     zrnyobiv43 ,         /* （連携用）予備項目Ｖ４３ */
     zrnansyuyouyobin10x2 ,         /* （連携用）案内収納用予備項目Ｎ１０＿２ */
     zrntawsosikikj ,         /* （連携用）問合せ先組織名（漢字） */
     zrntawyno ,         /* （連携用）問合せ先郵便番号 */
     zrntawadr1kj ,         /* （連携用）問合せ先住所１（漢字） */
     zrntawadr2kj ,         /* （連携用）問合せ先住所２（漢字） */
     zrntawadr3kj ,         /* （連携用）問合せ先住所３（漢字） */
     zrntawtelnov14 ,         /* （連携用）問合せ先電話番号Ｖ１４ */
     zrntawteluktkkanou1 ,         /* （連携用）問合せ先電話受付可能時間１ */
     zrntawteluktkkanou2 ,         /* （連携用）問合せ先電話受付可能時間２ */
     zrndai2tawsosikinmkj ,         /* （連携用）第２問合せ先組織名（漢字） */
     zrndai2tawtelno ,         /* （連携用）第２問合せ先電話番号 */
     zrnsclatosyono ,         /* （連携用）スクランブル後証券番号 */
     zrnsakunm15keta ,         /* （連携用）作成番号（１５桁） */
     zrnyobiv61 ,         /* （連携用）予備項目Ｖ６１ */
     zrnansyuyouyobin10x3 ,         /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrntuutinm30keta ,         /* （連携用）通知名称（３０桁） */
     zrnminyuttmsg1 ,         /* （連携用）未入通知メッセージ１ */
     zrnminyuttmsg2 ,         /* （連携用）未入通知メッセージ２ */
     zrnminyuttmsg3 ,         /* （連携用）未入通知メッセージ３ */
     zrnminyuttmsg4 ,         /* （連携用）未入通知メッセージ４ */
     zrnminyuttmsg5 ,         /* （連携用）未入通知メッセージ５ */
     zrnminyuttmsg6 ,         /* （連携用）未入通知メッセージ６ */
     zrnminyuttmsg7 ,         /* （連携用）未入通知メッセージ７ */
     zrnminyuttmsg8 ,         /* （連携用）未入通知メッセージ８ */
     zrnminyuttmsg9 ,         /* （連携用）未入通知メッセージ９ */
     zrnminyuttmsg10 ,         /* （連携用）未入通知メッセージ１０ */
     zrnminyuttmsg11 ,         /* （連携用）未入通知メッセージ１１ */
     zrnminyuttmsg12 ,         /* （連携用）未入通知メッセージ１２ */
     zrnyobiv174 ,         /* （連携用）予備項目Ｖ１７４ */
     zrnansyuyouyobin10x4 ,         /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrnpannainm ,         /* （連携用）保険料案内名称 */
     zrnhrkhou12keta ,         /* （連携用）払込方法（１２桁） */
     zrnsyono2 ,         /* （連携用）証券番号２ */
     zrnhhknnmkj ,         /* （連携用）被保険者名（漢字） */
     zrnnextkzhrnaiyou1 ,         /* （連携用）次回振替内容１ */
     zrnnextkzhrnaiyou2 ,         /* （連携用）次回振替内容２ */
     zrnnextkzhrnaiyou3 ,         /* （連携用）次回振替内容３ */
     zrnsaikokuyykk1 ,         /* （連携用）催告月猶予期間１ */
     zrnsaikokuyykk2 ,         /* （連携用）催告月猶予期間２ */
     zrnhrkmiraimsg1 ,         /* （連携用）振込依頼メッセージ１ */
     zrnhrkmiraimsg2 ,         /* （連携用）振込依頼メッセージ２ */
     zrnhrkmiraimsg3 ,         /* （連携用）振込依頼メッセージ３ */
     zrnzenhurinaiyou1 ,         /* （連携用）前回振替内容１ */
     zrnzenhurinaiyou2 ,         /* （連携用）前回振替内容２ */
     zrnzenhurinaiyou3 ,         /* （連携用）前回振替内容３ */
     zrnzenhurinaiyou4 ,         /* （連携用）前回振替内容４ */
     zrnyobiv196 ,         /* （連携用）予備項目Ｖ１９６ */
     zrnansyuyouyobin10x5 ,         /* （連携用）案内収納用予備項目Ｎ１０＿５ */
     zrnhurikaekz37keta1 ,         /* （連携用）振替口座（３７桁）１ */
     zrnhurikaekz37keta2 ,         /* （連携用）振替口座（３７桁）２ */
     zrnhurikaekz37keta3 ,         /* （連携用）振替口座（３７桁）３ */
     zrnhurikaekz37keta4 ,         /* （連携用）振替口座（３７桁）４ */
     zrnhurikaekz37keta5 ,         /* （連携用）振替口座（３７桁）５ */
     zrnhurikaekz37keta6 ,         /* （連携用）振替口座（３７桁）６ */
     zrnyobiv88 ,         /* （連携用）予備項目Ｖ８８ */
     zrnansyuyouyobin10x6 ,         /* （連携用）案内収納用予備項目Ｎ１０＿６ */
     zrnminyuttaddmsg1 ,         /* （連携用）未入通知追加メッセージ１ */
     zrnminyuttaddmsg2 ,         /* （連携用）未入通知追加メッセージ２ */
     zrnminyuttaddmsg3 ,         /* （連携用）未入通知追加メッセージ３ */
     zrnminyuttaddmsg4 ,         /* （連携用）未入通知追加メッセージ４ */
     zrnminyuttaddmsg5 ,         /* （連携用）未入通知追加メッセージ５ */
     zrnminyuttaddmsg6 ,         /* （連携用）未入通知追加メッセージ６ */
     zrnminyuttaddmsg7 ,         /* （連携用）未入通知追加メッセージ７ */
     zrnminyuttaddmsg8 ,         /* （連携用）未入通知追加メッセージ８ */
     zrnminyuttaddmsg9 ,         /* （連携用）未入通知追加メッセージ９ */
     zrnminyuttaddmsg10 ,         /* （連携用）未入通知追加メッセージ１０ */
     zrnminyuttaddmsg11 ,         /* （連携用）未入通知追加メッセージ１１ */
     zrnminyuttaddmsg12 ,         /* （連携用）未入通知追加メッセージ１２ */
     zrnminyuttaddmsg13 ,         /* （連携用）未入通知追加メッセージ１３ */
     zrnminyuttaddmsg14 ,         /* （連携用）未入通知追加メッセージ１４ */
     zrnminyuttaddmsg15 ,         /* （連携用）未入通知追加メッセージ１５ */
     zrnminyuttaddmsg16 ,         /* （連携用）未入通知追加メッセージ１６ */
     zrnminyuttaddmsg17 ,         /* （連携用）未入通知追加メッセージ１７ */
     zrnminyuttaddmsg18 ,         /* （連携用）未入通知追加メッセージ１８ */
     zrnminyuttaddmsg19 ,         /* （連携用）未入通知追加メッセージ１９ */
     zrnminyuttaddmsg20 ,         /* （連携用）未入通知追加メッセージ２０ */
     zrnminyuttaddmsg21 ,         /* （連携用）未入通知追加メッセージ２１ */
     zrnyobiv250 ,         /* （連携用）予備項目Ｖ２５０ */
     zrnyobiv60 ,         /* （連携用）予備項目Ｖ６０ */
     zrnansyuyouyobin10x7           /* （連携用）案内収納用予備項目Ｎ１０＿７ */
FROM ZT_KouzahuriMinyuTuutiRn_Z;