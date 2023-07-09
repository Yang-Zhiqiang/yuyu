CREATE VIEW ZT_HknkykIdouInfoTy AS SELECT
     ztykyktuukasyu ,         /* （中継用）契約通貨種類 */
     ztyidouymd ,         /* （中継用）異動日 */
     ztyidoujiyuukbnzfi ,         /* （中継用）異動事由区分（資産運用） */
     ztydatakanrino ,         /* （中継用）データ管理番号 */
     ztyrenno ,         /* （中継用）連番 */
     ztykeiyakuymd ,         /* （中継用）契約日 */
     ztyhhknnen2 ,         /* （中継用）被保険者年齢Ｖ２ */
     ztyhhknsei ,         /* （中継用）被保険者性別 */
     ztyhknsyukigou ,         /* （中継用）保険種類記号 */
     ztyaisyoumeikbn ,         /* （中継用）愛称名区分 */
     ztyzougenkbn ,         /* （中継用）増減区分 */
     ztyhokenkngk13 ,         /* （中継用）保険金額Ｎ１３ */
     ztyp13 ,         /* （中継用）保険料Ｎ１３ */
     ztyptumitatekin13 ,         /* （中継用）保険料積立金Ｎ１３ */
     ztykiykhnrikn13 ,         /* （中継用）解約返戻金Ｎ１３ */
     ztyidouhokenkngk ,         /* （中継用）異動保険金額 */
     ztyidoup ,         /* （中継用）異動保険料 */
     ztyidouptumitatekin ,         /* （中継用）異動保険料積立金 */
     ztyidoukiykhnrikn ,         /* （中継用）異動解約返戻金 */
     ztyhknkkn ,         /* （中継用）保険期間 */
     ztyyoteiriritun5 ,         /* （中継用）予定利率Ｎ５ */
     ztytumitatekinkbn ,         /* （中継用）積立金区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_HknkykIdouInfoTy_Z;