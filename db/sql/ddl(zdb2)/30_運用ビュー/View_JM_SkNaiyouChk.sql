CREATE VIEW JM_SkNaiyouChk AS SELECT
     sknaiyouchkkbn ,         /* 請求内容チェック区分 */
     yobidasimototaskkbn ,         /* 呼出元タスク区分 */
     msgsyubetu ,         /* メッセージ種別 */
     sateikaisouyouhikbn ,         /* 査定回送要否区分 */
     keisankahikbn ,         /* 計算可否区分 */
     messageId ,         /* メッセージＩＤ */
     msghikisuunaiyoukbn1 ,         /* メッセージ引数内容区分１ */
     msghikisuu1 ,         /* メッセージ引数１ */
     msghikisuunaiyoukbn2 ,         /* メッセージ引数内容区分２ */
     msghikisuu2 ,         /* メッセージ引数２ */
     msghikisuunaiyoukbn3 ,         /* メッセージ引数内容区分３ */
     msghikisuu3 ,         /* メッセージ引数３ */
     msghikisuunaiyoukbn4 ,         /* メッセージ引数内容区分４ */
     msghikisuu4 ,         /* メッセージ引数４ */
     msghikisuunaiyoukbn5 ,         /* メッセージ引数内容区分５ */
     msghikisuu5 ,         /* メッセージ引数５ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JM_SkNaiyouChk_Z;