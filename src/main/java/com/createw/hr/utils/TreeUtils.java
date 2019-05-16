package com.createw.hr.utils;

import java.util.ArrayList;
import java.util.List;

import com.createw.hr.domain.base.BasicTreeVo;

public class TreeUtils {

	 public static <T extends BasicTreeVo> List<T> getTree(List<T> sources){
	        List<T> rootList =  getTreeRoot(sources);
	        int len = rootList.size();
	        for(int i=0;i<len;i++){
	            getTreeChildNode(sources,rootList.get( i ));
	        }
	        return rootList;
	    }

	    /**
	     * 分离出根节点
	     * @return
	     */
	    private  static <T extends BasicTreeVo> List<T> getTreeRoot(List<T> sources){
	        List<T> rootList = new ArrayList<>(  );
	        for(int i=sources.size()-1;i>=0;i--){
	            if(sources.get( i ).getParentId()==null){
	                rootList.add( sources.remove( i ) );
	            }
	        }
	        return rootList;
	    }


	    /**
	     * 分离出子节点
	     * @return
	     */
	    private  static <T extends BasicTreeVo> void getTreeChildNode(List<T> sources,T parentNode){
	        T t = null;
	        for(int i=sources.size()-1;i>=0&i<sources.size();i--){
	            if(sources.get( i ).getParentId().equals(parentNode.getId())){
	                parentNode.getChildren().add(sources.get( i ));
	                t = sources.remove( i );
	                getTreeChildNode(sources,t);
	            }
	        }
	    }

}
