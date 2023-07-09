CREATE VIEW MT_SousaRirekiIvrInfo AS SELECT
     ttdksikibetuid ,         /* 手続識別ＩＤ */
     tyakusinymd ,         /* 着信日時 */
     dsgyoumucd ,         /* ＤＳ業務コード */
     syorinaiyoukbn ,         /* 処理内容区分 */
     callid ,         /* コールＩＤ */
     dssyorikekkakbn ,         /* ＤＳ処理結果区分 */
     setudankasyokbn ,         /* 切断箇所区分 */
     setudanriyuukbn ,         /* 切断理由区分 */
     tuuwatime ,         /* 通話時間 */
     ttdkisihyouzikbn ,         /* 手続意思表示区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_SousaRirekiIvrInfo_Z;