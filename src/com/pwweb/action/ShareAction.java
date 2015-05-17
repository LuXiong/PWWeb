package com.pwweb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.DataBaseListener;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.Suit;
import com.pwweb.pojo.User;
import com.pwweb.pojo.Comment;
import com.pwweb.pojo.Share;
import com.pwweb.pojo.UserShare;
import com.pwweb.pojo.UserSuit;
import com.pwweb.service.Imp.ShareServiceImp;
import com.pwweb.service.Imp.SuitServiceImp;
import com.pwweb.service.Imp.UserServiceImp;

public class ShareAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
 * share类的属性
 */
	private String id;
	private String userId;
	private String suitId;
	private String content;
	private Date createTime;
	private int isPublic;
/**
 * comment类的属性
 */
	private String commentId;
	private String commentShareId;
	private String commentUserId;
	private Date commentCreateTime;
	private String commentContent;
/**
 * UserShare类的属性
 */
	private String uShareId;
	private int isLike;
/**
 * UserSuit类的属性
 */
	private String uSuitId;
	private int isCollect;
	
	private long currentTime;
	private HashMap<String, String> jsonData;
	private ArrayList<HashMap<String, String>> arrayData;
	
	
	public HashMap<String, String> getJsonData() {
		return jsonData;
	}
	public void setJsonData(HashMap<String, String> jsonData) {
		this.jsonData = jsonData;
	}
	public ArrayList<HashMap<String, String>> getArrayData() {
		return arrayData;
	}
	public void setArrayData(ArrayList<HashMap<String, String>> arrayData) {
		this.arrayData = arrayData;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSuitId() {
		return suitId;
	}
	public void setSuitId(String suitId) {
		this.suitId = suitId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentShareId() {
		return commentShareId;
	}
	public void setCommentShareId(String commentShareId) {
		this.commentShareId = commentShareId;
	}
	public String getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}
	public Date getCommentCreateTime() {
		return commentCreateTime;
	}
	public void setCommentCreateTime(Date commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getuShareId() {
		return uShareId;
	}
	public void setuShareId(String uShareId) {
		this.uShareId = uShareId;
	}

	public String getuSuitId() {
		return uSuitId;
	}
	public void setuSuitId(String uSuitId) {
		this.uSuitId = uSuitId;
	}


	public long getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}
	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}
	public void setIsCollect(int isCollect) {
		this.isCollect = isCollect;
	}
	
	public int getIsPublic() {
		return isPublic;
	}
	public int getIsLike() {
		return isLike;
	}
	public int getIsCollect() {
		return isCollect;
	}
	/**
	 * 添加一条状态
	 * @return
	 */
	public String ActionAddShare(){
		jsonData = new HashMap<String,String>();
		final ShareServiceImp shareS = new ShareServiceImp();
		shareS.addShare(userId,suitId,content,isPublic,new DataBaseListener<Share>(){
			public void onSuccess(Share share){

				if(share!=null){
					jsonData.put("share", share.subJson());
			}
		}
			});
		return SUCCESS;
	}
	/**
	 * 删除一条状态
	 * @return
	 */
	public String ActionDeleteShare(){
		final ShareServiceImp shareS = new ShareServiceImp();
		shareS.deleteShare(id,new DataBaseListener<Share>(){
			public void onSuccess(Share share){
				if(share == null){
					System.out.println("delete share successfully");
				}
					
			}
		});
		return SUCCESS;
	}
	/**
	 * 更新当前时刻的状态，获取前面20条
	 * @return
	 */
	public String ActionUpdateCurrentShare(){
		arrayData = new ArrayList<HashMap<String,String>>();
		final ShareServiceImp shareS = new ShareServiceImp();
		shareS.updateCurrentShare(currentTime,new DataBaseListener<Share>(){
			public void onSuccess(List<Share> shareList){
				if(shareList!=null){
					for(int i = 0;i<shareList.size();i++){
						jsonData = new HashMap<String, String>();
						final JSONObject obj = new JSONObject();
						
						UserServiceImp userS = new UserServiceImp();
						SuitServiceImp ss = new SuitServiceImp();
						userS.queryUserById(shareList.get(i).getUserId(), new DataBaseListener<User>(){
							public void onSuccess(User user){
								if(user!=null){
									obj.put("user_name",user.getName());
									obj.put("user_img", user.getAvatar());
								}
							}
						});
						
						ss.QuerySuitById(shareList.get(i).getSuitId(), new DataBaseListener<Suit>(){
							public void onSuccess(Suit suit){
								if(suit!=null){
									obj.put("suit_img", suit.getImg());
									obj.put("suit_description", suit.getDescription());
								}
							}
						});
						obj.put("user_id",shareList.get(i).getUserId());
						obj.put("suit_id", shareList.get(i).getSuitId());
						obj.put("share_id", shareList.get(i).getId());
						obj.put("share_content", shareList.get(i).getContent());
						obj.put("share_create_time", shareList.get(i).getCreateTime().getTime());
//						jsonData.put("share", obj.toString());
//						arrayData.add(jsonData);
						shareS.getComment(shareList.get(i).getId(), new DataBaseListener<Comment>() {
							public void onSuccess(List<Comment> commentList){
								if(commentList!=null)
								{
//									ArrayList<HashMap<String, String>> arrayDataR = new ArrayList<HashMap<String, String>>();
//									HashMap<String,String> jsonDataR = new HashMap<String,String>();
									JSONArray jsonArray = new JSONArray();
									final JSONObject objc = new JSONObject();
									for(int i = 0;i<commentList.size();i++){
										//将comment一条一条的加载上去
//										jsonDataR = new HashMap<String,String>();
//										jsonDataR.put("comment", commentList.get(i).subJson());
//										arrayDataR.add(jsonDataR);	
										objc.put("comment_content", commentList.get(i).getContent());
										objc.put("comment_create_time", commentList.get(i).getCreateTime().getTime());
										objc.put("comment_share_id", commentList.get(i).getShareId());
										UserServiceImp u = new UserServiceImp();
										u.queryUserById(commentList.get(i).getUserId(), new DataBaseListener<User>(){
											public void onSuccess(User user){
												if(user!=null){
													objc.put("comment_user_id", user.getUid());
													objc.put("comment_user_name", user.getName());
													objc.put("comment_user_img", user.getAvatar());
												}
											}
										});
										jsonArray.add(objc);
									}
//									arrayData.addAll(arrayDataR);
                                    obj.put("comment_list", jsonArray);
									obj.put("comment_count", commentList.size());
								}
							}
						});
						shareS.getIsLike(shareList.get(i).getId(), new DataBaseListener<UserShare>(){
							public void onSuccess(List<UserShare> usList){
								if(usList!=null)
								{
//									HashMap<String,String> jsonDataT = new HashMap<String,String>();
//									jsonDataT.put("likeNum", Integer.toString(usList.size()));
//									arrayData.add(jsonDataT);
									obj.put("like_count", usList.size());
								}
							}
						});
						shareS.getIsCollect(shareList.get(i).getSuitId(), new DataBaseListener<UserSuit>(){
							public void onSuccess(List<UserSuit> usList){
								if(usList!=null){
									int iscollect = 0;
									for(int i = 0;i<usList.size();i++){
										if(usList.get(i).getUserId()==userId){
											iscollect=1;
										}
									}
									obj.put("is_collect", iscollect);
								}
							}
							
						});
						SuitServiceImp ilss = new SuitServiceImp();
						ilss.QuerySuitById(shareList.get(i).getSuitId(), new DataBaseListener<Suit>(){
							public void onSuccess(Suit suit){
								if(suit!=null){
									obj.put("is_like", suit.getIsLike());
								}
							}
						});
						
						
						jsonData.put("share", obj.toString());
						arrayData.add(jsonData);
					}
				}
			}
		});
		return SUCCESS;
	}
	/**
	 * 通过用户的UserId来获取该用户所有的状态
	 * @return
	 */
	public String ActionQueryShareByUserId(){
		arrayData = new ArrayList<HashMap<String, String>>();
//		ArrayList<HashMap<String, Object>> arrayRes = new ArrayList<HashMap<String, Object>>();
		final ShareServiceImp shareS = new ShareServiceImp();
		shareS.queryShareByUserId(userId,new DataBaseListener<Share>(){
			public void onSuccess(List<Share> shareList){
				if(shareList!=null){
					for(int i = 0;i<shareList.size();i++){
						jsonData = new HashMap<String, String>();
						final JSONObject obj = new JSONObject();
						
						UserServiceImp userS = new UserServiceImp();
						SuitServiceImp ss = new SuitServiceImp();
						userS.queryUserById(shareList.get(i).getUserId(), new DataBaseListener<User>(){
							public void onSuccess(User user){
								if(user!=null){
									obj.put("user_name",user.getName());
									obj.put("user_img", user.getAvatar());
								}
							}
						});
						
						ss.QuerySuitById(shareList.get(i).getSuitId(), new DataBaseListener<Suit>(){
							public void onSuccess(Suit suit){
								if(suit!=null){
									obj.put("suit_img", suit.getImg());
									obj.put("suit_description", suit.getDescription());
								}
							}
						});
						obj.put("user_id",shareList.get(i).getUserId());
						obj.put("suit_id", shareList.get(i).getSuitId());
						obj.put("share_id", shareList.get(i).getId());
						obj.put("share_content", shareList.get(i).getContent());
						obj.put("share_create_time", shareList.get(i).getCreateTime().getTime());
//						jsonData.put("share", obj.toString());
//						arrayData.add(jsonData);
						shareS.getComment(shareList.get(i).getId(), new DataBaseListener<Comment>() {
							public void onSuccess(List<Comment> commentList){
								if(commentList!=null)
								{
//									ArrayList<HashMap<String, String>> arrayDataR = new ArrayList<HashMap<String, String>>();
//									HashMap<String,String> jsonDataR = new HashMap<String,String>();
									JSONArray jsonArray = new JSONArray();
									final JSONObject objc = new JSONObject();
									for(int i = 0;i<commentList.size();i++){
										//将comment一条一条的加载上去
//										jsonDataR = new HashMap<String,String>();
//										jsonDataR.put("comment", commentList.get(i).subJson());
//										arrayDataR.add(jsonDataR);	
										objc.put("comment_content", commentList.get(i).getContent());
										objc.put("comment_create_time", commentList.get(i).getCreateTime().getTime());
										objc.put("comment_share_id", commentList.get(i).getShareId());
										UserServiceImp u = new UserServiceImp();
										u.queryUserById(commentList.get(i).getUserId(), new DataBaseListener<User>(){
											public void onSuccess(User user){
												if(user!=null){
													objc.put("comment_user_id", user.getUid());
													objc.put("comment_user_name", user.getName());
													objc.put("comment_user_img", user.getAvatar());
												}
											}
										});
										jsonArray.add(objc);
									}
//									arrayData.addAll(arrayDataR);
                                    obj.put("comment_list", jsonArray);
									obj.put("comment_count", commentList.size());
								}
							}
						});
						shareS.getIsLike(shareList.get(i).getId(), new DataBaseListener<UserShare>(){
							public void onSuccess(List<UserShare> usList){
								if(usList!=null)
								{
//									HashMap<String,String> jsonDataT = new HashMap<String,String>();
//									jsonDataT.put("likeNum", Integer.toString(usList.size()));
//									arrayData.add(jsonDataT);
									obj.put("like_count", usList.size());
								}
							}
						});
						shareS.getIsCollect(shareList.get(i).getSuitId(), new DataBaseListener<UserSuit>(){
							public void onSuccess(List<UserSuit> usList){
								if(usList!=null){
									int iscollect = 0;
									for(int i = 0;i<usList.size();i++){
										if(usList.get(i).getUserId()==userId){
											iscollect=1;
										}
									}
									obj.put("is_collect", iscollect);
								}
							}
							
						});
						SuitServiceImp ilss = new SuitServiceImp();
						ilss.QuerySuitById(shareList.get(i).getSuitId(), new DataBaseListener<Suit>(){
							public void onSuccess(Suit suit){
								if(suit!=null){
									obj.put("is_like", suit.getIsLike());
								}
							}
						});
						
						
						jsonData.put("share", obj.toString());
						arrayData.add(jsonData);
					}
				}
			}
		});
		return SUCCESS;
	}
	/**
	 * 获取该条状态下的所有评论并且显示
	 * @return
	 */
	public String ActionGetComment(){
		arrayData = new ArrayList<HashMap<String, String>>();
		final ShareServiceImp shareS = new ShareServiceImp();
		shareS.getComment(commentShareId,new DataBaseListener<Comment>(){
			public void onSuccess(List<Comment> commentList){
				if(commentList!=null){
					for(int i = 0;i<commentList.size();i++){
						jsonData = new HashMap<String, String>();
						jsonData.put("comment", commentList.get(i).subJson());
						arrayData.add(jsonData);
					}
					}
			}
		});
		return SUCCESS;
	}
	/**
	 * 获取该条状态下的点赞数并且显示出来
	 * @return
	 */
	public String ActionGetIsLike(){
		final ShareServiceImp shareS = new ShareServiceImp();
		shareS.getIsLike(id,new DataBaseListener<UserShare>(){
			public void onSuccess(List<UserShare> us){
				if(us!=null){
					System.out.println("isLikeNum" + us.size());
				}
			}
		});
		return SUCCESS;
	}

	public String ActionGetIsCollect(){
		final ShareServiceImp shareS = new ShareServiceImp();
		shareS.getIsCollect(suitId,new DataBaseListener<UserSuit>(){
			public void onSuccess(List<UserSuit> us){
				if(us!=null){
					System.out.println("isCollectNum:" + us.size());
				}
			}
		});
		return SUCCESS;
	}
	public String ActionAddComment(){
		jsonData = new HashMap<String,String>();
		final ShareServiceImp shareS = new ShareServiceImp();
		shareS.addComment(commentShareId,commentUserId,commentContent,new DataBaseListener<Comment>(){
			public void onSuccess(Comment comment){
				if(comment!=null){
					jsonData.put("comment", comment.subJson());
				}
			}
		});
		return SUCCESS;
	}
	
	public String ActionAddCollect(){
		jsonData = new HashMap<String, String>();
		final ShareServiceImp shareS = new ShareServiceImp();
		shareS.addCollect(userId,suitId,isCollect,new DataBaseListener<UserSuit>(){
			public void onSuccess(UserSuit us){
				if(us!=null){
					jsonData.put("isCollect", us.subJson());
				}
			}
		});
		return SUCCESS;
		
	}
	
	public String ActionAddLike(){
		jsonData = new HashMap<String, String>();
		final ShareServiceImp shareS = new ShareServiceImp();
		System.out.println("uShareUserId:" + userId);
		System.out.println("uShareShareId:" + id);
		shareS.addLike(userId,id,isLike,new DataBaseListener<UserShare>(){
			public void onSuccess(UserShare us){
				if(us!=null){
					jsonData.put("isLike", us.subJson());
				}
			}
		});
		return SUCCESS;
	}
}
