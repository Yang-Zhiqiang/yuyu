CREATE VIEW ZT_SmbcSkMeisaiRendouRn AS SELECT
     zrnsmbcdatakbn ,         /* （連携用）ＳＭＢＣ＿データ区分 */
     zrnsmbcdatasakuseiymd ,         /* （連携用）ＳＭＢＣ＿データ作成日 */
     zrnsmbchknkaisyacd ,         /* （連携用）ＳＭＢＣ＿保険会社コード */
     zrnsmbcuktkkanriid ,         /* （連携用）ＳＭＢＣ＿受付管理ＩＤ */
     zrnsmbcseihouktkzmymd ,         /* （連携用）ＳＭＢＣ＿生保受付済ＤＡＴＥ */
     zrnsmbcseihohbymd ,         /* （連携用）ＳＭＢＣ＿生保不備ＤＡＴＥ */
     zrnsmbcbankhnkykflg ,         /* （連携用）ＳＭＢＣ＿銀行返却フラグ */
     zrnsmbcseihohbksyymd ,         /* （連携用）ＳＭＢＣ＿生保不備解消ＤＡＴＥ */
     zrnsmbcseihohjyttykymd ,         /* （連携用）ＳＭＢＣ＿生保報状到着ＤＡＴＥ */
     zrnsmbcseihonyknzmymd ,         /* （連携用）ＳＭＢＣ＿生保入金済ＤＡＴＥ */
     zrnsmbcseihosnszmymd ,         /* （連携用）ＳＭＢＣ＿生保審査済ＤＡＴＥ */
     zrnsmbcseihosyknhkkzmymd ,         /* （連携用）ＳＭＢＣ＿生保証券発行済ＤＡＴＥ */
     zrnsmbcseihosyumoku ,         /* （連携用）ＳＭＢＣ＿生保種目 */
     zrnsmbcseihosyurui ,         /* （連携用）ＳＭＢＣ＿生保種類 */
     zrnsmbcsyono ,         /* （連携用）ＳＭＢＣ＿証券番号 */
     zrnsmbcsyonoedaban ,         /* （連携用）ＳＭＢＣ＿証券番号枝番 */
     zrnsmbcjktkflg ,         /* （連携用）ＳＭＢＣ＿条件付フラグ */
     zrnsmbcseihotrksymd ,         /* （連携用）ＳＭＢＣ＿生保取消ＤＡＴＥ */
     zrnsmbcseihohktymd ,         /* （連携用）ＳＭＢＣ＿生保否決ＤＡＴＥ */
     zrnsmbckykseiymd ,         /* （連携用）ＳＭＢＣ＿契約者生年月日 */
     zrnsmbckyknmkn ,         /* （連携用）ＳＭＢＣ＿契約者名（カナ） */
     zrnsmbcmosuktymd ,         /* （連携用）ＳＭＢＣ＿申込書受付ＤＡＴＥ */
     zrnsmbcmossyoriflg ,         /* （連携用）ＳＭＢＣ＿申込処理フラグ */
     zrnsmbckosyaareastyknr ,         /* （連携用）ＳＭＢＣ＿個社領域（進捗管理） */
     zrnyobiv60           /* （連携用）予備項目Ｖ６０ */
FROM ZT_SmbcSkMeisaiRendouRn_Z;