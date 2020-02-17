<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label for="title">タイトル</label><br/>
<input type="text" name="title" value="${foreign.title}"/>
<br/><br/>

<label for="contents">内容</label><br/>
<textarea name="contents" rows="10" cols="50">${foreign.contents}</textarea>
<br/><br/>

<label for="location">撮影場所</label><br/>
<input type="text" name="location" value="${foreign.location}"/>
<br/><br/>

<label for="lat">緯度</label><br/>
<input type="text" name="lat" value="${foreign.lat}"/>
<br/><br/>

<label for="lng">経度</label><br/>
<input type="text" name="lng" value="${foreign.lng}"/>
<br/><br/>

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>