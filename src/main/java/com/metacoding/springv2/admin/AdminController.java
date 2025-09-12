package com.metacoding.springv2.admin;

import com.metacoding.springv2.board.*;
import com.metacoding.springv2.user.*;
import com.metacoding.springv2.core.util.Resp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import jakarta.validation.Valid;

import com.metacoding.springv2.auth.*;

@RequestMapping("/api/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {
    private final BoardService boardService;
    private final UserService userService;

    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<?> deleteBoard(@PathVariable("boardId") Integer boardId) {
        boardService.관리자_게시글삭제(boardId);
        return Resp.ok(null);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<?> rolesUpdate(@PathVariable("userId") Integer userId,
            @Valid @RequestBody AuthRequest.RolesDTO requestDTO, Errors errors) {
        var responseDTO = userService.관리자_역할수정(userId,requestDTO);
        return Resp.ok(responseDTO);
    }
}
