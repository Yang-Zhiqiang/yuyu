CREATE VIEW JM_SiinHantei AS SELECT
     siboukariuketukejigeninkbn ,         /* 死亡仮受付時原因区分 */
     seikyuuuketukejigeninkbn ,         /* 請求受付時原因区分 */
     kansensyouumukbn ,         /* 感染症有無区分 */
     saigaikanouseiumukbn ,         /* 災害可能性有無区分 */
     husyounosiumukbn ,         /* 不詳の死有無区分 */
     sateikaksaigaikanouseikbn ,         /* 査定回送要否確認（災害可能性）区分 */
     sateikakhusyousikbn ,         /* 査定回送要否確認（不詳の死）区分 */
     siinkbn ,         /* 死因区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JM_SiinHantei_Z;